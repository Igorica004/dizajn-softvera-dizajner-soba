package raf.draft.dsw.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.Data;
import raf.draft.dsw.core.ApplicationFramework;
import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.model.messages.Message;
import raf.draft.dsw.model.messages.MessageType;
import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.nodes.DraftNodeComposite;
import raf.draft.dsw.model.painters.ElementPainter;
import raf.draft.dsw.model.roomobjects.RoomElement;
import raf.draft.dsw.model.structures.Building;
import raf.draft.dsw.model.structures.Project;
import raf.draft.dsw.model.structures.Room;
import raf.draft.dsw.tabbedpane.TabbedPaneImplementation;
import raf.draft.dsw.tabbedpane.view.RoomView;
import raf.draft.dsw.tree.DraftTreeImplementation;
import raf.draft.dsw.tree.model.DraftTreeItem;
import raf.draft.dsw.utils.DraftNodeUtils;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Enumeration;

@Data
public class Serializer {
    private static int patternCounter=1;
    private static Serializer instance = null;
    public static Serializer getInstanca() {
        if(instance == null)
            instance = new Serializer();
        return instance;
    }
    private Serializer(){
    }
    public void serialize(String path) {
        DraftTreeItem draftTreeItem = MainFrame.getInstanca().getDraftTree().getSelectedNode();
        if(draftTreeItem == null){
            ApplicationFramework.getInstanca().getMessageGenerator().generateMessage(new Message(MessageType.GRESKA,LocalDateTime.now(),"Niste izabrali projekat koji zelite da sacuvate"));
            return;
        }
        Project selektovan = DraftNodeUtils.getProjectParent(draftTreeItem.getDraftNode());
        if(!selektovan.isMenjan()){
            System.out.println("Projekat nije menjan");
            return;
        }
        String putanja = selektovan.getPutanja();
        if(path == null && putanja == null){
            JFileChooser chooser = new JFileChooser();
            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                putanja = chooser.getSelectedFile().getAbsolutePath();
                System.out.println(putanja);
            }
        } else if(path != null) {
            putanja = path;
            System.out.println(putanja);
        } else System.out.println(putanja);
        selektovan.setPutanja(putanja);
        selektovan.setMenjan(false);

        ObjectMapper mapper = new ObjectMapper();

        ArrayList<ArrayList<PainterContainer>> containers = new ArrayList<>();
        ArrayList<Room> rooms = DraftNodeUtils.getRooms(selektovan);
        TabbedPaneImplementation tabbedPane = (TabbedPaneImplementation)MainFrame.getInstanca().getDesniPanel().getTabbedPane();
        for(Room room : rooms) {
            if(tabbedPane.getTabbedPaneModel().getSviTabovi().containsKey(room)){
                ArrayList<PainterContainer> container = new ArrayList<>();
                for(ElementPainter elementpainter:tabbedPane.getTabbedPaneModel().getSviTabovi().get(room).getPainters()){
                    container.add(new PainterContainer(elementpainter));
                }
                containers.add(container);
            }
        }

        ObjectNode rootNode = mapper.createObjectNode();
        rootNode.set("projekat",mapper.valueToTree(selektovan));
        rootNode.set("painteri",mapper.valueToTree(containers));


        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(putanja),rootNode);
        } catch (Exception e) {
            ApplicationFramework.getInstanca().getMessageGenerator().generateMessage(new Message(MessageType.GRESKA,LocalDateTime.now(),"Neuspesno otvaranje fajla"));
        }

    }

    public void deserialize() {
        Project project = null;
        ArrayList<ArrayList<PainterContainer>> containers = null;

        ObjectMapper mapper = createObjectMapper();
        JFileChooser chooser = new JFileChooser();
        if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File fajl = chooser.getSelectedFile();
            try {
                ObjectNode rootNode = (ObjectNode) mapper.readTree(fajl);
                project = mapper.treeToValue(rootNode.get("projekat"),Project.class);
                containers = mapper.treeToValue(rootNode.get("painteri"),new TypeReference<ArrayList<ArrayList<PainterContainer>>>(){});
            } catch (Exception e) {
                ApplicationFramework.getInstanca().getMessageGenerator().generateMessage(new Message(MessageType.GRESKA,LocalDateTime.now(),"Neuspesno otvaranje fajla"));
                System.out.println(e.getMessage());
                return;
            }
        } else return;

        project.setRoditelj(((DraftTreeImplementation)MainFrame.getInstanca().getDraftTree()).getProjectManager());
        for(DraftNode child:project.getChildren()){
            if(child instanceof Building building){
                for(DraftNode room: building.getChildren()){
                    room.setRoditelj(building);
                }
            }
            child.setRoditelj(project);
        }
        for(DraftNode child:project.getChildren()){
            if(child instanceof Building building){
                for(DraftNode room: building.getChildren()){
                    for(DraftNode element: ((DraftNodeComposite)room).getChildren()){
                        element.setRoditelj(room);
                    }
                }
            }
            else{
                for(DraftNode element: ((DraftNodeComposite)child).getChildren()){
                    element.setRoditelj(child);
                }
            }
        }
        DraftTreeImplementation draftTree = ((DraftTreeImplementation)MainFrame.getInstanca().getDraftTree());
        project.setMenjan(false);
        draftTree.addProject(project);

        ArrayList<Room> rooms = DraftNodeUtils.getRooms(project);
        int i=0,j=0;
        TabbedPaneImplementation tabbedPane = (TabbedPaneImplementation)MainFrame.getInstanca().getDesniPanel().getTabbedPane();
        for(Room room:rooms) {
            RoomView roomView = new RoomView(room);
            for(DraftNode roomElement:room.getChildren()){
                roomView.getPainters().add(containers.get(i).get(j).getPainter((RoomElement) roomElement));
                j++;
            }
            j=0;
            tabbedPane.getTabbedPaneModel().getSviTabovi().put(room,roomView);
            i++;
        }
    }

    public void savePattern(){
        while(new File(String.format("src/resources/pattern%d.json",patternCounter)).exists()){
            patternCounter++;
        }
        String putanja = "src/main/resources/pattern"+patternCounter+++".json";
        DraftTreeItem draftTreeItem = MainFrame.getInstanca().getDraftTree().getSelectedNode();
        if(draftTreeItem == null){
            ApplicationFramework.getInstanca().getMessageGenerator().generateMessage(new Message(MessageType.GRESKA,LocalDateTime.now(),"Nije selektovana soba za cuvanje sablona"));
            return;
        }
        DraftNode draftNode = draftTreeItem.getDraftNode();
        if(!(draftNode instanceof Room)){
            ApplicationFramework.getInstanca().getMessageGenerator().generateMessage(new Message(MessageType.GRESKA,LocalDateTime.now(),"Morate da izaberete sobu za koju zelite da sacuvate sablon"));
            return;
        }
        Room room = (Room)draftNode;
        ArrayList<PainterContainer> painteri = new ArrayList<>();
        TabbedPaneImplementation tabbedPane = (TabbedPaneImplementation)MainFrame.getInstanca().getDesniPanel().getTabbedPane();
        RoomView tab = tabbedPane.getTabbedPaneModel().getSviTabovi().get(room);
        for(ElementPainter painter:tab.getPainters()){
            painteri.add(new PainterContainer(painter));
        }
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode rootNode = mapper.createObjectNode();
        rootNode.set("room",mapper.valueToTree(room));
        rootNode.set("painteri",mapper.valueToTree(painteri));
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(putanja),rootNode);
        } catch (IOException e) {
            System.out.println("Ne uspesno otvaranje fajla\n"+e.getMessage());
        }
    }
    public void loadPattern(){
        DraftTreeItem draftTreeItem = MainFrame.getInstanca().getDraftTree().getSelectedNode();
        DraftNode draftNode = draftTreeItem.getDraftNode();
        if(!(draftNode instanceof Room)){
            ApplicationFramework.getInstanca().getMessageGenerator().generateMessage(new Message(MessageType.GRESKA,LocalDateTime.now(),"Morate da izaberete sobu na koju hocete da primenite sablon"));
            return;
        }

        Room room = (Room)draftNode;
        Room pattern;
        ArrayList<PainterContainer> painteri = new ArrayList<>();

        ObjectMapper mapper = createObjectMapper();
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("src/main/resources"));
        if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File fajl = chooser.getSelectedFile();
            try {
                ObjectNode rootNode = (ObjectNode) mapper.readTree(fajl);
                pattern = mapper.treeToValue(rootNode.get("room"),Room.class);
                painteri = mapper.treeToValue(rootNode.get("painteri"), new TypeReference<ArrayList<PainterContainer>>(){});

            } catch (Exception e) {
                ApplicationFramework.getInstanca().getMessageGenerator().generateMessage(new Message(MessageType.GRESKA,LocalDateTime.now(),"Neuspesno otvaranje fajla"));
                System.out.println(e.getMessage());
                return;
            }
        }else return;

        TabbedPaneImplementation tabbedPane = (TabbedPaneImplementation)MainFrame.getInstanca().getDesniPanel().getTabbedPane();
        tabbedPane.getTabbedPaneModel().getSviTabovi().remove(room);
        tabbedPane.getTabbedPaneModel().getNoviTabovi().remove(room);

        room.getChildren().clear();
        for(DraftNode element:pattern.getChildren()){
            room.getChildren().add(element);
        }
        room.setDimenzija(pattern.getDimenzija());
        RoomView roomView = new RoomView(room);
        int i=0;
        for(DraftNode element:room.getChildren()){
            element.setRoditelj(room);
            element.setColor(room.getColor());
            roomView.getPainters().add(painteri.get(i).getPainter((RoomElement) element));
            i++;
        }

        tabbedPane.getTabbedPaneModel().getSviTabovi().put(room,roomView);
        DraftTreeImplementation draftTree = ((DraftTreeImplementation)MainFrame.getInstanca().getDraftTree());
        Enumeration<?> enumeration = draftTree.getDepthFirstEnumeration();
        DraftTreeItem draftTreeItem1 = DraftNodeUtils.createDraftTreeItem(room);
        while(enumeration.hasMoreElements()){
            DraftTreeItem dti = (DraftTreeItem)enumeration.nextElement();
            if(dti.getDraftNode().equals(room)){
                DraftTreeItem roditelj = (DraftTreeItem)dti.getParent();
                roditelj.remove(dti);
                roditelj.add(draftTreeItem1);
            }
        }
        draftTree.notifySubscribers(null);
    }

    private ObjectMapper createObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Color.class, new JsonDeserializer<Color>() {
            @Override
            public Color deserialize(JsonParser parser, DeserializationContext context) throws IOException {
                JsonNode node = parser.getCodec().readTree(parser);
                int red = node.get("red").asInt();
                int green = node.get("green").asInt();
                int blue = node.get("blue").asInt();
                int alpha = node.has("alpha") ? node.get("alpha").asInt() : 255; // Podrazumevana vrednost
                return new Color(red, green, blue, alpha);
            }
        });
        mapper.registerModule(module);
        return mapper;
    }
}

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
import raf.draft.dsw.tree.DraftTree;
import raf.draft.dsw.tree.DraftTreeImplementation;
import raf.draft.dsw.tree.model.DraftTreeItem;
import raf.draft.dsw.utils.DraftNodeUtils;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

@Data
public class Serializer {
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

        ObjectMapper mapper = new ObjectMapper();
        JFileChooser chooser = new JFileChooser();
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
}

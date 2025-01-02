package raf.draft.dsw.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import lombok.Data;
import raf.draft.dsw.core.ApplicationFramework;
import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.model.messages.Message;
import raf.draft.dsw.model.messages.MessageType;
import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.structures.Project;
import raf.draft.dsw.tree.DraftTreeImplementation;
import raf.draft.dsw.utils.DraftNodeUtils;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;

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
        DraftNode draftNode = MainFrame.getInstanca().getDraftTree().getSelectedNode().getDraftNode();
        Project selektovan = DraftNodeUtils.getProjectParent(draftNode);
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
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(putanja),selektovan);
        } catch (Exception e) {
            ApplicationFramework.getInstanca().getMessageGenerator().generateMessage(new Message(MessageType.GRESKA,LocalDateTime.now(),"Neuspesno otvaranje fajla"));
        }

    }

    public void deserialize() {
        ObjectMapper mapper = new ObjectMapper();
        Project project = null;
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
                project = mapper.readValue(fajl,Project.class);
            } catch (Exception e) {
                ApplicationFramework.getInstanca().getMessageGenerator().generateMessage(new Message(MessageType.GRESKA,LocalDateTime.now(),"Neuspesno otvaranje fajla"));
                System.out.println(e.getMessage());
                return;
            }
        } else return;


        ((DraftTreeImplementation)MainFrame.getInstanca().getDraftTree()).addProject(project);

    }
}

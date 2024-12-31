package raf.draft.dsw.serializer;

import lombok.Data;
import raf.draft.dsw.core.ApplicationFramework;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

@Data
public class Serializer {
    private static Serializer instance = null;
    private File saveFile;
    public static Serializer getInstanca() {
        if(instance == null)
            instance = new Serializer();
        return instance;
    }
    private Serializer(){
        saveFile = null;
    }
    public void serialize(File file) {
        if(file == null && saveFile == null){
            JFileChooser chooser = new JFileChooser();
            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                saveFile = chooser.getSelectedFile();
                System.out.println(saveFile);
            }
        } else if(file != null) {
            saveFile = file;
            System.out.println(saveFile);
        } else System.out.println(saveFile);


    }

    public void deserialize(File file) {

    }
}

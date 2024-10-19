package raf.draft.dsw.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import raf.draft.dsw.gui.swing.MainFrame;


public class ApplicationFramework {
    //buduca polja za model celog projekta
    @Getter
    private static ApplicationFramework instanca = new ApplicationFramework();
    private ApplicationFramework(){
        initialize();
    }

    public void initialize(){
        MainFrame mainFrame = MainFrame.getInstanca();
        mainFrame.setVisible(true);
    }
}

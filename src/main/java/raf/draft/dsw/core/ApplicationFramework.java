package raf.draft.dsw.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import raf.draft.dsw.controller.messagegenerator.ConsoleLogger;
import raf.draft.dsw.controller.messagegenerator.MessageGenerator;
import raf.draft.dsw.gui.swing.MainFrame;

import java.io.Console;

@Data
public class ApplicationFramework {
    //buduca polja za model celog projekta
    @Getter
    private static ApplicationFramework instanca = new ApplicationFramework();
    private ApplicationFramework(){
        initialize();
    }
    private MessageGenerator messageGenerator = new MessageGenerator();
    private ConsoleLogger consoleLogger = new ConsoleLogger();
    public void initialize(){
        MainFrame mainFrame = MainFrame.getInstanca();
        mainFrame.setVisible(true);
    }
}

package raf.draft.dsw.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import raf.draft.dsw.controller.messagegenerator.ConsoleLogger;
import raf.draft.dsw.controller.messagegenerator.FileLogger;
import raf.draft.dsw.controller.messagegenerator.LoggerFactory;
import raf.draft.dsw.controller.messagegenerator.MessageGenerator;
import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.model.repository.DraftExplorerImplementation;
import raf.draft.dsw.model.repository.DraftRepository;

import java.io.Console;
import java.io.File;

@Data
public class ApplicationFramework {
    //buduca polja za model celog projekta
    private static ApplicationFramework instanca = null;
    private ApplicationFramework(){}
    public static ApplicationFramework getInstanca(){
        if(instanca == null){
            instanca = new ApplicationFramework();
            instanca.initialize();
        }
        return instanca;
    }

    private LoggerFactory loggerFactory;
    private MessageGenerator messageGenerator;
    private ConsoleLogger consoleLogger;
    private FileLogger fileLogger;
    protected DraftRepository draftRepository;

    public void initialize(){
        loggerFactory = new LoggerFactory();
        messageGenerator = new MessageGenerator();
        consoleLogger = (ConsoleLogger)loggerFactory.napraviLogger("Console");
        fileLogger = (FileLogger)loggerFactory.napraviLogger("File");
        draftRepository = new DraftExplorerImplementation();

        MainFrame mainFrame = MainFrame.getInstanca();
        mainFrame.setVisible(true);
    }
}

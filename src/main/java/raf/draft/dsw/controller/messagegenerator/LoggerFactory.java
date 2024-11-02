package raf.draft.dsw.controller.messagegenerator;

import raf.draft.dsw.core.ApplicationFramework;
import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.model.messages.Message;
import raf.draft.dsw.model.messages.MessageType;

import java.time.LocalDateTime;

public class LoggerFactory {
    //jedna metoda, string
    public Logger napraviLogger(String type) {
        Logger logger = null;
        if(type.equals("Console"))
            logger = new ConsoleLogger();
        else if(type.equals("File"))
            logger = new FileLogger();
        if(logger == null){
            Message poruka = new Message(MessageType.GRESKA, LocalDateTime.now(),"LoggerFatory: Nepostojeci tim logger-a");
            ApplicationFramework.getInstanca().getMessageGenerator().generateMessage(poruka);
            return null;
        }
        ApplicationFramework.getInstanca().getMessageGenerator().addSubscriber(logger);
        return logger;
    }
}
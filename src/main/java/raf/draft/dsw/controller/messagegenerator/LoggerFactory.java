package raf.draft.dsw.controller.messagegenerator;

import raf.draft.dsw.controller.observer.Notification;
import raf.draft.dsw.core.ApplicationFramework;
import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.model.messages.Message;

public class LoggerFactory {

    //jedna metoda, string
    /*public Logger createConsoleLogger(){
        ConsoleLogger consoleLogger = new ConsoleLogger();
        ApplicationFramework.getInstanca().getMessageGenerator().addSubscriber(consoleLogger);
        return consoleLogger;
    }
    public Logger createFileLogger(){
        FileLogger fileLogger = new FileLogger();
        ApplicationFramework.getInstanca().getMessageGenerator().addSubscriber(fileLogger);
        return fileLogger;
    }*/

    public Logger napraviLogger(String tip)
    {
        if(tip.equals("File"))
        {
            return new FileLogger();
        }
        else if(tip.equals("Console"))
        {
            return new ConsoleLogger();
        }
        else return null;
    }
}
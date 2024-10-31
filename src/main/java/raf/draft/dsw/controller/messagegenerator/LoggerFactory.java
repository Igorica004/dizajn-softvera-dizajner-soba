package raf.draft.dsw.controller.messagegenerator;

import raf.draft.dsw.core.ApplicationFramework;
import raf.draft.dsw.gui.swing.MainFrame;

public class LoggerFactory {
    //jedna metoda, string
    public Logger createConsoleLogger(){
        ConsoleLogger consoleLogger = new ConsoleLogger();
        ApplicationFramework.getInstanca().getMessageGenerator().addSubscriber(consoleLogger);
        return consoleLogger;
    }
    public Logger createFileLogger(){
        FileLogger fileLogger = new FileLogger();
        ApplicationFramework.getInstanca().getMessageGenerator().addSubscriber(fileLogger);
        return fileLogger;
    }
}
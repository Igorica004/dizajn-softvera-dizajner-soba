package raf.draft.dsw.controller.messagegenerator;

import raf.draft.dsw.core.ApplicationFramework;
import raf.draft.dsw.gui.swing.MainFrame;

public class LoggerFactory {
    public ConsoleLogger createConsoleLogger(){
        ConsoleLogger consoleLogger = new ConsoleLogger();
        ApplicationFramework.getInstanca().getMessageGenerator().addSubscriber(consoleLogger);
        return consoleLogger;
    }
    public FileLogger createFileLogger(){
        FileLogger fileLogger = new FileLogger();
        ApplicationFramework.getInstanca().getMessageGenerator().addSubscriber(fileLogger);
        return fileLogger;
    }
}
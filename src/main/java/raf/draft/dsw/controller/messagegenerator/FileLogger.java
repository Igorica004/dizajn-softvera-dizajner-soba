package raf.draft.dsw.controller.messagegenerator;

import raf.draft.dsw.controller.observer.Notification;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileLogger implements Logger{

    @Override
    public void log(Notification notification) {
        String str = notification.getPoruka().toString();
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter("src/main/resources/log.txt", true));
            pw.println(str);
            pw.close();
        } catch (IOException e) {
            System.out.println("Greska prilkom pisanja u fajl: "+e.getMessage());
        }

    }

    @Override
    public void update(Notification notification) {
        log(notification);
    }

}

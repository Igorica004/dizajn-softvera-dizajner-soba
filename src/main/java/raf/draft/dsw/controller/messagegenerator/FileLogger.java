package raf.draft.dsw.controller.messagegenerator;

import raf.draft.dsw.controller.observer.Notification;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements Logger{

    @Override
    public void log(Notification notification) throws IOException {
        String str = notification.getPoruka().toString();
        BufferedWriter writer = new BufferedWriter(new FileWriter("/log.txt", true));
        writer.append(str);
        writer.append('\n');

        writer.close();

    }

    @Override
    public void update(Notification notification) {

    }

}

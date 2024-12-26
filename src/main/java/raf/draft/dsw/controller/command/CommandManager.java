package raf.draft.dsw.controller.command;

import java.util.ArrayList;

public class CommandManager {
    private ArrayList<AbstractCommand> commands = new ArrayList<>();
    private int currentCommand = 0;

    public void doCommand() {
        if(currentCommand < commands.size()) {
            commands.get(currentCommand++).doCommand();

        }
    }
}

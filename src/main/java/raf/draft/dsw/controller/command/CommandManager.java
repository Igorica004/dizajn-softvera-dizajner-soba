package raf.draft.dsw.controller.command;

import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.tabbedpane.view.RoomView;

import javax.swing.*;
import java.util.ArrayList;

public class CommandManager {
    private ArrayList<AbstractCommand> commands = new ArrayList<>();
    private int currentCommand = 0;

    public void addCommand(AbstractCommand command) {
        while(currentCommand < commands.size()) {
            commands.remove(currentCommand);
        }
        commands.add(command);
        doCommand();
    }
    public void doCommand() {
        RoomView rv = MainFrame.getInstanca().getDesniPanel().getSelectedTab();
        if(currentCommand < commands.size()) {
            MainFrame.getInstanca().getActionManager().getUndoAction().setEnabled(true);
            commands.get(currentCommand++).doCommand();
            rv.repaint();
        }
        if(currentCommand == commands.size()) {
            MainFrame.getInstanca().getActionManager().getRedoAction().setEnabled(false);
        }
    }

    public void undoCommand(){
        RoomView rv = MainFrame.getInstanca().getDesniPanel().getSelectedTab();
        if(currentCommand > 0){
            MainFrame.getInstanca().getActionManager().getRedoAction().setEnabled(true);
            commands.get(--currentCommand).undoCommand();
            rv.repaint();
        }
        if(currentCommand==0){
            MainFrame.getInstanca().getActionManager().getUndoAction().setEnabled(false);
        }
    }
}

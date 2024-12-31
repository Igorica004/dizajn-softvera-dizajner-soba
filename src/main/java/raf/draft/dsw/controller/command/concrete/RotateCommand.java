package raf.draft.dsw.controller.command.concrete;

import raf.draft.dsw.controller.command.AbstractCommand;
import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.model.painters.ElementPainter;
import raf.draft.dsw.tabbedpane.view.RoomView;

import java.awt.*;

public class RotateCommand extends AbstractCommand {
    private double stariUgao, noviUgao;

    public RotateCommand(double stariUgao, double noviUgao) {
        this.noviUgao = noviUgao;
        this.stariUgao = stariUgao;
    }

    @Override
    public void doCommand() {
        RoomView rv = MainFrame.getInstanca().getDesniPanel().getSelectedTab();
        for(ElementPainter ep: rv.getSelektovani())
        {
            ep.setRotateRatio(noviUgao);
        }
    }

    @Override
    public void undoCommand() {
        RoomView rv = MainFrame.getInstanca().getDesniPanel().getSelectedTab();
        for(ElementPainter ep: rv.getSelektovani())
        {
            ep.setRotateRatio(stariUgao);
        }
    }
}

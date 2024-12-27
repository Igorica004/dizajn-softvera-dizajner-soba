package raf.draft.dsw.controller.command.concrete;

import raf.draft.dsw.controller.command.AbstractCommand;
import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.model.painters.ElementPainter;
import raf.draft.dsw.tabbedpane.view.RoomView;

import java.awt.*;
import java.util.ArrayList;

public class MoveCommand extends AbstractCommand {
    ArrayList<Point> stareKoordinate = new ArrayList<>();
    ArrayList<Point> noveKoordinate =  new ArrayList<>();
    public MoveCommand(ArrayList<Point> stareKoordinate, ArrayList<Point> noveKoordinate)
    {
        this.stareKoordinate.addAll(stareKoordinate);
        this.noveKoordinate.addAll(noveKoordinate);
    }

    @Override
    public void doCommand() {
        RoomView rv = MainFrame.getInstanca().getDesniPanel().getSelectedTab();
        int i = 0;
        for(ElementPainter r : rv.getSelektovani())
        {
            //((RoomDevice)r.getShape()).setLokacija(new Point(razlikaX + stareKoordinate.get(i).x, razlikaY + stareKoordinate.get(i).y));
            r.setLokacija(new Point(noveKoordinate.get(i).x, noveKoordinate.get(i).y));
            i++;
        }
        rv.repaint();
    }

    @Override
    public void undoCommand() {
        RoomView rv = MainFrame.getInstanca().getDesniPanel().getSelectedTab();
        int i = 0;
        for(ElementPainter r : rv.getSelektovani())
        {
            //((RoomDevice)r.getShape()).setLokacija(new Point(razlikaX + stareKoordinate.get(i).x, razlikaY + stareKoordinate.get(i).y));
            r.setLokacija(new Point(stareKoordinate.get(i).x, stareKoordinate.get(i).y));
            i++;
        }
        rv.repaint();
    }
}

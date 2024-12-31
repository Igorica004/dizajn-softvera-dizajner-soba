package raf.draft.dsw.controller.command.concrete;

import raf.draft.dsw.controller.command.AbstractCommand;
import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.model.painters.ElementPainter;
import raf.draft.dsw.tabbedpane.view.RoomView;

import java.awt.*;
import java.util.ArrayList;

public class ResizeCommand extends AbstractCommand {
    ArrayList<Dimension> stareDimenzije = new ArrayList<>();
    ArrayList<Dimension> noveDimenzije =  new ArrayList<>();
    public ResizeCommand(ArrayList<Dimension> stareDimenzije, ArrayList<Dimension> noveDimenzije)
    {
        this.stareDimenzije.addAll(stareDimenzije);
        this.noveDimenzije.addAll(noveDimenzije);
    }

    @Override
    public void doCommand() {
        RoomView rv = MainFrame.getInstanca().getDesniPanel().getSelectedTab();
        int i = 0;
        for(ElementPainter r : rv.getSelektovani())
        {
            //((RoomDevice)r.getShape()).setLokacija(new Point(razlikaX + stareKoordinate.get(i).x, razlikaY + stareKoordinate.get(i).y));
            r.setDimenzija(new Dimension(noveDimenzije.get(i).width, noveDimenzije.get(i).height));
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
            r.setDimenzija(new Dimension(stareDimenzije.get(i).width, stareDimenzije.get(i).height));
            i++;
        }
        rv.repaint();
    }
}

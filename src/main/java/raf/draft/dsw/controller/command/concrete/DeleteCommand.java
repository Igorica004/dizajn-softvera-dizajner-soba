package raf.draft.dsw.controller.command.concrete;

import raf.draft.dsw.controller.command.AbstractCommand;
import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.model.painters.ElementPainter;
import raf.draft.dsw.tabbedpane.TabbedPaneImplementation;
import raf.draft.dsw.tabbedpane.view.RoomView;
import raf.draft.dsw.tree.DraftTreeImplementation;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class DeleteCommand extends AbstractCommand {
    ArrayList<ElementPainter> obrisani = new ArrayList<>();
    Point point;
    public DeleteCommand(Point point) {
        this.point = point;
    }
    @Override
    public void doCommand() {
        RoomView rv = MainFrame.getInstanca().getDesniPanel().getSelectedTab();
        Iterator<ElementPainter> iterator = rv.getPainters().iterator();
        while (iterator.hasNext()) {
            ElementPainter ep = iterator.next();
            for (Shape shape : ep.getShapes()) {
                if (shape.contains(point)) {
                    ((DraftTreeImplementation)MainFrame.getInstanca().getDraftTree()).removeRoomElement(ep.getRoomElement());
                    if(!obrisani.contains(ep)) {
                        obrisani.add(ep);
                    }
                    iterator.remove();
                    break;
                }
            }
        }
        for(ElementPainter ep: rv.getSelektovani())
        {
            iterator = rv.getPainters().iterator();
            while (iterator.hasNext()) {
                ElementPainter elementPainter = iterator.next();
                if(elementPainter == ep)
                    ((DraftTreeImplementation)MainFrame.getInstanca().getDraftTree()).removeRoomElement(ep.getRoomElement());
            }
            rv.getPainters().remove(ep);
            if(!obrisani.contains(ep)) {
                obrisani.add(ep);
            }
        }
    }

    @Override
    public void undoCommand() {
        RoomView rv = MainFrame.getInstanca().getDesniPanel().getSelectedTab();
        for(ElementPainter ep: obrisani)
        {
            rv.addPainter(ep);
            ((DraftTreeImplementation)MainFrame.getInstanca().getDraftTree()).addRoomElement(ep.getRoomElement());
        }
    }
}

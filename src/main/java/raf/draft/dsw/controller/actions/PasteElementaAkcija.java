package raf.draft.dsw.controller.actions;

import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.model.painters.*;
import raf.draft.dsw.model.roomobjects.*;
import raf.draft.dsw.tabbedpane.TabbedPaneImplementation;
import raf.draft.dsw.tabbedpane.view.RoomView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class PasteElementaAkcija extends AbstractRoomAction{
    public PasteElementaAkcija() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("/images/clipboard-icon.png"));
        putValue(NAME, "Paste");
        putValue(SHORT_DESCRIPTION, "Paste");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        RoomView rv = MainFrame.getInstanca().getDesniPanel().getSelectedTab();
        ElementPainter k;
        for(ElementPainter ep:rv.getKopirani())
        {
            if(ep.getRoomElement() instanceof Bojler)
            {
                k = new BojlerPainter((RoomElement) (ep.getRoomElement().clone(ep.getRoomElement())),
                        new Point(ep.getLokacija().x+15,ep.getLokacija().y+15),ep.getDimenzija());
            }
            else if(ep.getRoomElement() instanceof Kada)
            {
                k = new KadaPainter((RoomElement) (ep.getRoomElement().clone(ep.getRoomElement())),
                        new Point(ep.getLokacija().x+15,ep.getLokacija().y+15),ep.getDimenzija());
            }
            else if(ep.getRoomElement() instanceof Lavabo)
            {
                k = new LavaboPainter((RoomElement) (ep.getRoomElement().clone(ep.getRoomElement())),
                        new Point(ep.getLokacija().x+15,ep.getLokacija().y+15),ep.getDimenzija());
            }
            else if(ep.getRoomElement() instanceof Vrata)
            {
                k = new VrataPainter((RoomElement) (ep.getRoomElement().clone(ep.getRoomElement())),
                        new Point(ep.getLokacija().x+15,ep.getLokacija().y+15),ep.getDimenzija());
            }
            else if(ep.getRoomElement() instanceof WCSolja)
            {
                k = new WCSoljaPainter((RoomElement) (ep.getRoomElement().clone(ep.getRoomElement())),
                        new Point(ep.getLokacija().x+15,ep.getLokacija().y+15),ep.getDimenzija());
            }
            else
            {
                k = new KrevetPainter((RoomElement) (ep.getRoomElement().clone(ep.getRoomElement())),
                        new Point(ep.getLokacija().x+15,ep.getLokacija().y+15),ep.getDimenzija());
            }

            rv.addPainter(k);
        }
        rv.repaint();
    }
}

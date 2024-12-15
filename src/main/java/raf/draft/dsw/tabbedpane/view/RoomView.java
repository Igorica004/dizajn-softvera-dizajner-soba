package raf.draft.dsw.tabbedpane.view;

import lombok.Data;
import raf.draft.dsw.controller.observer.ISubscriber;
import raf.draft.dsw.controller.observer.Notification;
import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.model.painters.ElementPainter;
import raf.draft.dsw.model.painters.RectanglePainter;
import raf.draft.dsw.model.structures.Room;
import raf.draft.dsw.utils.MisaListener;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.*;

@Data
public class RoomView extends JPanel implements ISubscriber {
    private Room room;
    private RectanglePainter okvirSobe = new RectanglePainter(new Point(10,10),new Dimension(1,1));

    private ArrayList<ElementPainter> painters = new ArrayList<>();
    private Set<ElementPainter> selektovani = new HashSet<>();
    private double zoomFactor = 1;

    public RoomView(Room room) {
        this();
        this.room = room;
        MisaListener listener = new MisaListener();
        addMouseListener(listener);
        addMouseMotionListener(listener);
        addMouseWheelListener(listener);
    }
    public RoomView(){
        MainFrame.getInstanca().getDesniPanel().subscribeToStates(this);
    }
    public Double getScale(){
        double scaleX = getWidth()/room.getDimenzija().getWidth();
        double scaleY = getHeight()/room.getDimenzija().getHeight();
        double manje1 = Math.min(scaleX, scaleY);
        scaleX = (1.0*getWidth()-20)/getWidth();
        scaleY = (1.0*getHeight()-20)/getHeight();
        double manje2 = Math.min(scaleX, scaleY);
        return manje1*manje2;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform at = new AffineTransform();
        at.scale(zoomFactor, zoomFactor);
        g2d.transform(at);
        g2d.drawRect(10,10,(int)(room.getDimenzija().width*getScale()),
                    (int)(room.getDimenzija().height*getScale())); //painter sobe mora da postoji kao promenljiva da bismo proveravali da li je element unutra
        at.scale(1,1);
        for (ElementPainter elementPainter : painters) {
            elementPainter.paint(g2d);
        }
    }

    public void addPainter(ElementPainter elementPainter) {
        painters.add(elementPainter);
        repaint();
    }
    public void removePainter(ElementPainter elementPainter) {
        painters.remove(elementPainter);
        repaint();
    }

    public void addSelektovani(ElementPainter selektovani) {
        selektovani.getRoomElement().setStroke(new BasicStroke(3));
        this.selektovani.add(selektovani);
        //for(ElementPainter r: this.selektovani)
        //{
        //    System.out.print(r.getRoomElement().getNaziv()+" ");
        //}
        //System.out.println("\n");
    }
    public void removeSelektovani() {
        for (ElementPainter selektovani : selektovani) {
            selektovani.getRoomElement().setStroke(new BasicStroke(BasicStroke.CAP_BUTT));
        }
        this.selektovani.clear();
        repaint();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoomView roomView)) return false;
        return Objects.equals(room, roomView.room);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(room);
    }

    @Override
    public void update(Notification notification) {
        repaint();
    }
}

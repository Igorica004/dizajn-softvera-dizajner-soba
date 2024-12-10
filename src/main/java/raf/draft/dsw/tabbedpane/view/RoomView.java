package raf.draft.dsw.tabbedpane.view;

import lombok.Data;
import raf.draft.dsw.model.painters.ElementPainter;
import raf.draft.dsw.model.roomobjects.RoomDevice;
import raf.draft.dsw.model.roomobjects.RoomElement;
import raf.draft.dsw.model.structures.Room;
import raf.draft.dsw.utils.MisaListener;

import javax.swing.*;
import java.awt.*;
import java.util.*;

@Data
public class RoomView extends JPanel {
    private Room room;
    private double scale;
    private ArrayList<ElementPainter> painters = new ArrayList<>();
    private Set<ElementPainter> selektovani = new HashSet<>();

    public RoomView(Room room) {
        this();
        this.room = room;
        MisaListener listener = new MisaListener();
        addMouseListener(listener);
        addMouseMotionListener(listener);
    }
    public RoomView(){

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawRect(10,10,room.getDimenzija().width,room.getDimenzija().height);
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
        ((RoomDevice)selektovani.getRoomElement()).setStroke(new BasicStroke(3));
        this.selektovani.add(selektovani);
        for(ElementPainter r: this.selektovani)
        {
            System.out.print(r.getRoomElement().getNaziv()+" ");
        }
        System.out.println("\n");
    }
    public void removeSelektovani() {
        for (ElementPainter selektovani : selektovani) {
            ((RoomDevice)selektovani.getRoomElement()).setStroke(new BasicStroke(BasicStroke.CAP_BUTT));
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
}

package raf.draft.dsw.tabbedpane.view;

import lombok.Data;
import raf.draft.dsw.controller.command.CommandManager;
import raf.draft.dsw.controller.observer.ISubscriber;
import raf.draft.dsw.controller.observer.Notification;
import raf.draft.dsw.core.ApplicationFramework;
import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.gui.swing.OrganizeMyRoomProzor;
import raf.draft.dsw.model.messages.Message;
import raf.draft.dsw.model.messages.MessageType;
import raf.draft.dsw.model.painters.ElementPainter;
import raf.draft.dsw.model.painters.RectanglePainter;
import raf.draft.dsw.model.roomobjects.RoomElement;
import raf.draft.dsw.model.structures.Room;
import raf.draft.dsw.tree.DraftTreeImplementation;
import raf.draft.dsw.utils.MisaListener;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.time.LocalDateTime;
import java.util.*;

@Data
public class RoomView extends JPanel implements ISubscriber {
    private Room room;
    private RectanglePainter okvirSobe = new RectanglePainter(new Point(10,10),new Dimension(1,1));

    private ArrayList<ElementPainter> painters = new ArrayList<>();
    private Set<ElementPainter> selektovani = new HashSet<>();
    private ArrayList<ElementPainter> kopirani = new ArrayList<>();

    private CommandManager commandManager = new CommandManager();
    private double zoomFactor = 1;
    private double prevZoomFactor = 1;
    private double xOffset = 0;
    private double yOffset = 0;
    private AffineTransform transform = new AffineTransform();

    public RoomView(Room room) {
        this();
        this.room = room;
        MainFrame.getInstanca().getActionManager().getOrganizeMyRoomAction().setEnabled(true);
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
//        Point p =new Point();
//        p.x = (int)(room.getDimenzija().width*getScale()) - 30;
//        p.y = (int)(room.getDimenzija().height*getScale()) - 30;
        g2d.transform(getTransform());
        g2d.drawRect(10,10,(int)(room.getDimenzija().width*getScale()),
                    (int)(room.getDimenzija().height*getScale()));
        //g2d.fillRect(p.x,p.y,40,40);
        for (ElementPainter elementPainter : painters) {
            elementPainter.setScaleRatio(zoomFactor);
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
    }
    public void removeSelektovani() {
        for (ElementPainter selektovani : selektovani) {
            selektovani.getRoomElement().setStroke(new BasicStroke(BasicStroke.CAP_BUTT));
        }
        this.selektovani.clear();
        repaint();
    }
    public void organize()
    {
        OrganizeMyRoomProzor prozor = new OrganizeMyRoomProzor();
        prozor.setVisible(true);
        int sirinaPolja = 0, visinaPolja = 0, n, m;
        for(ElementPainter e: prozor.getSpisakElemenata())
        {
            sirinaPolja = Math.max(sirinaPolja, e.getDimenzija().width);
            visinaPolja = Math.max(visinaPolja, e.getDimenzija().height);
        }
        n = (int)((room.getDimenzija().width * getScale())/sirinaPolja);
        m = (int)((room.getDimenzija().height * getScale())/visinaPolja);
        if(prozor.getSpisakElemenata().size()>n*m || sirinaPolja > room.getDimenzija().width*getScale() || visinaPolja > room.getDimenzija().height*getScale()){
            Message messsage = new Message(MessageType.GRESKA, LocalDateTime.now(),"pogresno uneti elementi");
            ApplicationFramework.getInstanca().getMessageGenerator().generateMessage(messsage);
            return;
        }

        int[][] matrica = new int[n][m];
        int top = 0, bottom = n-1, left = 0, right = m-1;
        int count = 0;
        while (top <= bottom && left <= right) {

            // Print top row from left to right
            for (int i = left; i <= right; ++i) {
                if(count==prozor.getSpisakElemenata().size()) break;
                Point p = new Point();

                if(top==0) p.y = 10;
                else p.y = visinaPolja*top + 10;
                if(i==m-1) p.x = (int)(room.getDimenzija().width*getScale()) - prozor.getSpisakElemenata().get(count).getDimenzija().width + 10;
                else p.x = sirinaPolja*i + 10;

                prozor.getSpisakElemenata().get(count).setLokacija(p);
                addPainter(prozor.getSpisakElemenata().get(count));
                ((DraftTreeImplementation)MainFrame.getInstanca().getDraftTree()).addRoomElement(prozor.getSpisakElemenata().get(count).getRoomElement());
                matrica[top][i] = count++;
            }
            top++;

            // Print right column from top to bottom
            for (int i = top; i <= bottom; ++i) {
                if(count==prozor.getSpisakElemenata().size()) break;
                Point p = new Point();

                if(right==m-1) p.x = (int)(room.getDimenzija().width*getScale()) - prozor.getSpisakElemenata().get(count).getDimenzija().width + 10;
                else p.x = sirinaPolja*right + 10;
                if(i==n-1) p.y = (int)(room.getDimenzija().height*getScale()) - prozor.getSpisakElemenata().get(count).getDimenzija().height + 10;
                else p.y = visinaPolja*i + 10;

                prozor.getSpisakElemenata().get(count).setLokacija(p);
                addPainter(prozor.getSpisakElemenata().get(count));
                ((DraftTreeImplementation)MainFrame.getInstanca().getDraftTree()).addRoomElement(prozor.getSpisakElemenata().get(count).getRoomElement());
                matrica[i][right] = count++;
            }
            right--;

            // Print bottom row from right to left (if exists)
            if (top <= bottom) {
                for (int i = right; i >= left; --i) {
                    if(count==prozor.getSpisakElemenata().size()) break;
                    Point p = new Point();

                    if(i==0) p.x = 10;
                    else p.x = sirinaPolja*right + 10;
                    if(bottom==n-1) p.y = (int)(room.getDimenzija().height*getScale()) - prozor.getSpisakElemenata().get(count).getDimenzija().height + 10;
                    else p.y = visinaPolja*i + 10;
                    prozor.getSpisakElemenata().get(count).setLokacija(p);
                    addPainter(prozor.getSpisakElemenata().get(count));
                    ((DraftTreeImplementation)MainFrame.getInstanca().getDraftTree()).addRoomElement(prozor.getSpisakElemenata().get(count).getRoomElement());
                    matrica[bottom][i] = count++;
                }
                bottom--;
            }

            // Print left column from bottom to top (if exists)
            if (left <= right) {
                if(count==prozor.getSpisakElemenata().size()) break;
                for (int i = bottom; i >= top; --i) {
                    if(count==prozor.getSpisakElemenata().size()) break;

                    Point p = new Point();

                    if(left==0) p.x = (int)(room.getDimenzija().width*getScale()) - prozor.getSpisakElemenata().get(count).getDimenzija().width + 10;
                    else p.x = sirinaPolja*right + 10;

                    prozor.getSpisakElemenata().get(count).setLokacija(new Point(sirinaPolja*left + 10, visinaPolja*i + 10));
                    addPainter(prozor.getSpisakElemenata().get(count));
                    ((DraftTreeImplementation)MainFrame.getInstanca().getDraftTree()).addRoomElement(prozor.getSpisakElemenata().get(count).getRoomElement());
                    matrica[i][left] = count++;
                }
                left++;
            }
        }
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                System.out.print(matrica[i][j] + " ");
            }
            System.out.print("\n");
        }
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

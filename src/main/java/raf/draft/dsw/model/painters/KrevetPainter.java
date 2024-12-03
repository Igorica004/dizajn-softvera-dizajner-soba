package raf.draft.dsw.model.painters;

import raf.draft.dsw.model.roomobjects.Prototype;
import raf.draft.dsw.model.roomobjects.RoomElement;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class KrevetPainter extends DevicePainter{
    public KrevetPainter(RoomElement prototype) {
        super(prototype);
        shape = new Rectangle(prototype.getLocacija().x,prototype.getLocacija().y,prototype.getLocacija().x+prototype.getDimenzija().width,prototype.getLocacija().y+prototype.getDimenzija().height);
    }

//    @Override
//    public void paint(Graphics2D g) {
//        super.paint(g);
//        g.setPaint(Color.BLACK);
//        g.drawRect(10,10,25,25);
//        //g.drawRect(prototype.getLocacija().x,prototype.getLocacija().y,prototype.getLocacija().x+prototype.getDimenzija().width,prototype.getLocacija().y+prototype.getDimenzija().height);
//        //g.fillRect(prototype.getLocacija().x,prototype.getLocacija().y,prototype.getLocacija().x+prototype.getDimenzija().width,prototype.getLocacija().y+prototype.getDimenzija().height);
//    }
}

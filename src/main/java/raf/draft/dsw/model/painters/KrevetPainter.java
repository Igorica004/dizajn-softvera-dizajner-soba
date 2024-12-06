package raf.draft.dsw.model.painters;

import raf.draft.dsw.model.roomobjects.RoomElement;

import java.awt.*;

public class KrevetPainter extends DevicePainter{
    public KrevetPainter(RoomElement prototype) {
        super(prototype);
        shape = new Rectangle(prototype.getLokacija().x,prototype.getLokacija().y,prototype.getLokacija().x+prototype.getDimenzija().width,prototype.getLokacija().y+prototype.getDimenzija().height);
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

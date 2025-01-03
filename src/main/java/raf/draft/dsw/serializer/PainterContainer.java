package raf.draft.dsw.serializer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import raf.draft.dsw.model.painters.*;
import raf.draft.dsw.model.roomobjects.RoomElement;

import java.awt.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PainterContainer {
    private int x,y,width,height;
    private String type;
    public PainterContainer(ElementPainter painter) {
        x = painter.getLokacija().x;
        y = painter.getLokacija().y;
        width = painter.getDimenzija().width;
        height = painter.getDimenzija().height;

        if(painter instanceof BojlerPainter) type = "bojler";
        if(painter instanceof KadaPainter) type = "kada";
        if(painter instanceof LavaboPainter) type = "lavabo";
        if(painter instanceof KrevetPainter) type = "krevet";
        if(painter instanceof VrataPainter) type = "vrata";
        if(painter instanceof WCSoljaPainter) type = "wcsolja";
    }

    public ElementPainter getPainter(RoomElement element) {
        if(type.equals("bojler"))
            return new BojlerPainter(element,new Point(x,y),new Dimension(width,height));
        if(type.equals("kada"))
            return new KadaPainter(element,new Point(x,y),new Dimension(width,height));
        if(type.equals("lavabo"))
            return new LavaboPainter(element,new Point(x,y),new Dimension(width,height));
        if(type.equals("krevet"))
            return new KrevetPainter(element,new Point(x,y),new Dimension(width,height));
        if(type.equals("vrata"))
            return new VrataPainter(element,new Point(x,y),new Dimension(width,height));
        if(type.equals("wcsolja"))
            return new WCSoljaPainter(element,new Point(x,y),new Dimension(width,height));
        System.out.println("Neuspesno dobijanje paintera");
        return null;
    }
}

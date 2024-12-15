package raf.draft.dsw.model.painters;

import lombok.Getter;
import lombok.Setter;
import raf.draft.dsw.model.roomobjects.RoomDevice;
import raf.draft.dsw.model.shapes.RoomShape;

import java.awt.*;
@Getter
@Setter
public abstract class DevicePainter extends ElementPainter {
    public DevicePainter(RoomDevice roomDevice) {
        super(roomDevice,roomDevice.getLokacija());
    }

    @Override
    public void paint(Graphics2D g) {
        for(RoomShape roomShape:shapes){
            g.setStroke(roomElement.getStroke());
            g.setPaint(roomElement.getPaint());
            g.rotate(roomElement.getRotateRatio(), ((RoomDevice)roomElement).getLokacija().x + ((RoomDevice)roomElement).getDimenzija().width/2,
                    ((RoomDevice)roomElement).getLokacija().y + ((RoomDevice)roomElement).getDimenzija().height/2);
            g.fill(roomShape);
            g.setPaint(Color.black);
            g.draw(roomShape);
            g.rotate(-roomElement.getRotateRatio(), ((RoomDevice)roomElement).getLokacija().x + ((RoomDevice)roomElement).getDimenzija().width/2,
                    ((RoomDevice)roomElement).getLokacija().y + ((RoomDevice)roomElement).getDimenzija().height/2);
        }
    }
    public void setScale(double scale){
        for(RoomShape roomShape:shapes){
            roomShape.setScale(scale);
        }
    }
    public abstract void azurirajVelicine();
    public void setSize(int width, int height){
        this.dimenzija.width = width;
        this.dimenzija.height = height;
        azurirajVelicine();
    }
    public void setDimenzija(Dimension dimenzija) {
        ((RoomDevice)roomElement).setDimenzija(dimenzija);
    }
}

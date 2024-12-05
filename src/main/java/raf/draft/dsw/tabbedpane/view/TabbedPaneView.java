package raf.draft.dsw.tabbedpane.view;

import lombok.Data;
import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.structures.Project;
import raf.draft.dsw.model.structures.Room;
import raf.draft.dsw.utils.ColorUtils;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

@Data
public class TabbedPaneView extends JTabbedPane {
    public TabbedPaneView() {
        super(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
        setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
    }
    public void initialize(HashMap<DraftNode, RoomView> tabovi){
        if(tabovi == null) return;
        removeAll();
        String label,punNaziv;
        for(Map.Entry<DraftNode, RoomView> child: tabovi.entrySet()) {
            RoomView roomView = child.getValue();
            roomView.removeAll();
            if(roomView.getRoom().getRoditelj() instanceof Project)
            {
                label = roomView.getRoom().getRoditelj().getNaziv() + "/";
                punNaziv = roomView.getRoom().getNaziv();
            }
            else{
                label = roomView.getRoom().getRoditelj().getRoditelj().getNaziv() + "/" + roomView.getRoom().getRoditelj().getNaziv();
                punNaziv = String.format("%s/%s", roomView.getRoom().getRoditelj().getNaziv(), roomView.getRoom().getNaziv());
            }
            roomView.add(new JLabel(label));
            Room rum = (Room)(roomView.getRoom());
            roomView.add(new JLabel(rum.getDimenzija().toString()));
            addTab(punNaziv, roomView);
        }
        for(int i=0; i<getTabCount(); i++){
            setBackgroundAt(i,((RoomView)getComponentAt(i)).getRoom().getColor());
            setForegroundAt(i, ColorUtils.getContrastingTextColor(((RoomView) getComponentAt(i)).getRoom().getColor()));
        }
    }


}

package raf.draft.dsw.tabbedpane;

import lombok.Data;
import raf.draft.dsw.controller.observer.ISubscriber;
import raf.draft.dsw.controller.observer.Notification;
import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.tabbedpane.model.TabbedPaneModel;
import raf.draft.dsw.tabbedpane.view.TabbedPaneView;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

@Data
public class TabbedPaneImplementation implements TabbedPaneInterface {
    private TabbedPaneView tabbedPaneView = new TabbedPaneView();
    private TabbedPaneModel tabbedPaneModel = new TabbedPaneModel();
    private static Color bojaProjekta=null;

    @Override
    public void updateTabbedPane() {
        tabbedPaneModel.update();
        tabbedPaneView.initialize(tabbedPaneModel.getTabovi());
    }
}

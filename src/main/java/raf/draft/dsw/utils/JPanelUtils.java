package raf.draft.dsw.utils;

import javax.swing.*;
import java.awt.*;

public class JPanelUtils {
    public static JPanel makeHBox(Container... containers) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        for (Container container : containers) {
            panel.add(container);
        }
        return panel;
    }
    public static JPanel makeVBox(Container... containers) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        for (Container container : containers) {
            panel.add(container);
        }
        return panel;
    }
}

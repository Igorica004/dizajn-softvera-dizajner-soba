package raf.draft.dsw.gui.swing;

import lombok.Data;
import lombok.Getter;
import raf.draft.dsw.controller.ActionManager;

import javax.swing.*;
import java.awt.*;
@Data
public class MainFrame extends JFrame {
    //buduca polja za sve komponente view-a na glavnom prozoru
    @Getter
    private static MainFrame instanca = new MainFrame();
    private ActionManager actionManager = new ActionManager();
    private MainFrame(){
        initialize();
    }

    private void initialize(){
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth / 2, screenHeight / 2);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("DraftRoom");

        MyMenuBar menu = new MyMenuBar();
        setJMenuBar(menu);

        MyToolBar toolBar = new MyToolBar(this);
        add(toolBar, BorderLayout.NORTH);
    }
}

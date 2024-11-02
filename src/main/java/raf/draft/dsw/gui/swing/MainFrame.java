package raf.draft.dsw.gui.swing;

import lombok.Data;
import lombok.Getter;
import raf.draft.dsw.controller.actions.ActionManager;
import raf.draft.dsw.controller.observer.ISubscriber;
import raf.draft.dsw.controller.observer.Notification;
import raf.draft.dsw.core.ApplicationFramework;

import javax.swing.*;
import java.awt.*;
@Data
//treba da bude sub
public class MainFrame extends JFrame implements ISubscriber {
    //buduca polja za sve komponente view-a na glavnom prozoru
    private static MainFrame instanca = null;
    private ActionManager actionManager = new ActionManager();
    private MainFrame(){}
    public static MainFrame getInstanca(){
        if(instanca == null){
            instanca = new MainFrame();
            instanca.initialize();
        }
        return instanca;
    }

    private void initialize(){
        ApplicationFramework.getInstanca().getMessageGenerator().addSubscriber(this);
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

        MyToolBar toolBar = new MyToolBar();
        add(toolBar, BorderLayout.NORTH);
    }

    @Override
    public void update(Notification notification) {
        ProzorGreska prozorGreska = new ProzorGreska(notification);
        prozorGreska.setVisible(true);
    }
}

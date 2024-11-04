package raf.draft.dsw.gui.swing;

import lombok.Data;
import lombok.Getter;
import raf.draft.dsw.controller.actions.ActionManager;
import raf.draft.dsw.controller.observer.ISubscriber;
import raf.draft.dsw.controller.observer.Notification;
import raf.draft.dsw.core.ApplicationFramework;
import raf.draft.dsw.tree.DraftTree;
import raf.draft.dsw.tree.DraftTreeImplementation;

import javax.swing.*;
import java.awt.*;
@Data
//treba da bude sub
public class MainFrame extends JFrame implements ISubscriber {
    //buduca polja za sve komponente view-a na glavnom prozoru
    private static MainFrame instanca = null;
    private ActionManager actionManager = new ActionManager();
    private DraftTree draftTree = new DraftTreeImplementation();

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

        JTree projectExplorer = draftTree.genrateTree(ApplicationFramework.getInstanca().getDraftRepository().getProjectExplorer());

        JPanel desktop = new JPanel();

        JScrollPane scroll=new JScrollPane(projectExplorer);
        scroll.setMinimumSize(new Dimension(200,150));
        JSplitPane split=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,scroll,desktop);
        getContentPane().add(split,BorderLayout.CENTER);
        split.setDividerLocation(250);
        split.setOneTouchExpandable(true);
    }

    @Override
    public void update(Notification notification) {
        ProzorGreska prozorGreska = new ProzorGreska(notification);
        prozorGreska.setVisible(true);
    }
}

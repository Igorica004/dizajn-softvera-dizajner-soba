package raf.draft.dsw.controller.actions;

import com.sun.tools.javac.Main;
import raf.draft.dsw.core.ApplicationFramework;
import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.model.structures.Project;
import raf.draft.dsw.tree.DraftTreeImplementation;
import raf.draft.dsw.tree.model.DraftTreeItem;
import raf.draft.dsw.tree.view.DraftTreeView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NoviProjekatAkcija implements ActionListener {
    private JTextField autor,naziv,putanja;
    private JFrame jFrame;

    public NoviProjekatAkcija(JTextField autor, JTextField naziv, JTextField putanja, JFrame jFrame) {
        this.autor = autor;
        this.naziv = naziv;
        this.putanja = putanja;
        this.jFrame = jFrame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //premestiti u drafttreeimplementation metodu addchild/createchild, ovde samo pozvati to
        DraftTreeItem draftTreeItem = new DraftTreeItem(new Project(autor.getText(),ApplicationFramework.getInstanca().getDraftRepository().getProjectExplorer(),putanja.getText(), naziv.getText()));
        ((DraftTreeImplementation)MainFrame.getInstanca().getDraftTree()).addProject(draftTreeItem);
        DraftTreeView treeView = ((DraftTreeImplementation) MainFrame.getInstanca().getDraftTree()).getTreeView();
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
        jFrame.dispose();
    }
}

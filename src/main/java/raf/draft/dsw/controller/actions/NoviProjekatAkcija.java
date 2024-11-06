package raf.draft.dsw.controller.actions;

import raf.draft.dsw.core.ApplicationFramework;
import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.model.structures.Project;
import raf.draft.dsw.tree.DraftTreeImplementation;
import raf.draft.dsw.tree.model.DraftTreeItem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NoviProjekatAkcija implements ActionListener {
    private String autor,naziv,putanja;
    private JFrame jFrame;

    public NoviProjekatAkcija(String autor, String naziv, String putanja, JFrame jFrame) {
        this.autor = autor;
        this.naziv = naziv;
        this.putanja = putanja;
        this.jFrame = jFrame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        DraftTreeItem draftTreeItem = new DraftTreeItem(new Project(autor, ApplicationFramework.getInstanca().getDraftRepository().getProjectExplorer(),putanja, naziv));
        ((DraftTreeImplementation)MainFrame.getInstanca().getDraftTree()).addProject(draftTreeItem);
        jFrame.dispose();
    }
}

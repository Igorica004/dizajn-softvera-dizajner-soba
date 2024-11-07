package raf.draft.dsw.tree;

import lombok.Getter;
import raf.draft.dsw.controller.actions.NoviProjekatAkcija;
import raf.draft.dsw.controller.actions.NoviProjekatFormaAkcija;
import raf.draft.dsw.gui.swing.ProzorNoviProjekatForma;
import raf.draft.dsw.model.factory.Factory;
import raf.draft.dsw.model.factory.FactoryProject;
import raf.draft.dsw.model.factory.FactoryUtils;
import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.nodes.DraftNodeComposite;
import raf.draft.dsw.model.repository.DraftExplorerImplementation;
import raf.draft.dsw.model.structures.Building;
import raf.draft.dsw.model.structures.Project;
import raf.draft.dsw.model.structures.ProjectExplorer;
import raf.draft.dsw.tree.model.DraftTreeItem;
import raf.draft.dsw.tree.view.DraftTreeView;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import java.util.Random;

@Getter
public class DraftTreeImplementation implements DraftTree {
    private DraftTreeView treeView;
    private DefaultTreeModel treeModel;

    @Override
    public DraftTreeView genrateTree(ProjectExplorer projectExplorer) {
        DraftTreeItem root = new DraftTreeItem(projectExplorer);
        treeModel = new DefaultTreeModel(root);
        treeView = new DraftTreeView(treeModel);
        return treeView;
    }

    @Override
    public void addChild() {
        DraftTreeItem selectedTreeItem = getSelectedNode();
        DraftNodeComposite selectedNode = (DraftNodeComposite) selectedTreeItem.getDraftNode();
        DraftNode newNode = null;
        Factory factory = FactoryUtils.getFactory(selectedNode);
        if(selectedNode instanceof ProjectExplorer){
            NoviProjekatAkcija noviProjekatAkcija = new NoviProjekatAkcija();
            Project project = noviProjekatAkcija.getProject();
            newNode = factory.createNode(null,project.getIme(),project.getAutor(),project.getPutanja());
        }
        selectedNode.addChild(newNode);
        selectedTreeItem.add(new DraftTreeItem(newNode));
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);


    }
    public void addProject(DraftTreeItem child){
        ((DraftTreeItem)treeModel.getRoot()).add(child);
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);

    }

    @Override
    public DraftTreeItem getSelectedNode() {
        return (DraftTreeItem) treeView.getLastSelectedPathComponent();
    }

    private DraftNode createChild(DraftNode draftNode) {
        //ovde staviti fabriku
        return draftNode;
    }

}

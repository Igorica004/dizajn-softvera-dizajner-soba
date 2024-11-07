package raf.draft.dsw.tree;

import lombok.Getter;
import raf.draft.dsw.controller.actions.NoviBuildingRoomAkcija;
import raf.draft.dsw.controller.actions.NoviProjekatAkcija;
import raf.draft.dsw.controller.actions.NoviRoomAkcija;
import raf.draft.dsw.core.ApplicationFramework;
import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.model.factory.Factory;
import raf.draft.dsw.model.factory.FactoryBuilding;
import raf.draft.dsw.model.factory.FactoryProject;
import raf.draft.dsw.model.factory.FactoryRoom;
import raf.draft.dsw.model.messages.Message;
import raf.draft.dsw.model.messages.MessageType;
import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.nodes.DraftNodeComposite;
import raf.draft.dsw.model.structures.Building;
import raf.draft.dsw.model.structures.Project;
import raf.draft.dsw.model.structures.ProjectExplorer;
import raf.draft.dsw.model.structures.Room;
import raf.draft.dsw.tree.model.DraftTreeItem;
import raf.draft.dsw.tree.view.DraftTreeView;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import java.time.LocalDateTime;

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

        if(!(selectedTreeItem.getDraftNode() instanceof DraftNodeComposite)){
            Message messsage = new Message(MessageType.GRESKA, LocalDateTime.now(),"Soba ne moze da ima dete");
            ApplicationFramework.getInstanca().getMessageGenerator().generateMessage(messsage);
            return;
        }

        DraftNodeComposite selectedNode = (DraftNodeComposite) selectedTreeItem.getDraftNode();
        DraftNode newNode = null;
        Factory factory;

        if(selectedNode instanceof ProjectExplorer){
            factory = new FactoryProject();
            NoviProjekatAkcija noviProjekatAkcija = MainFrame.getInstanca().getActionManager().getNoviProjekatAkcija();
            Project project = noviProjekatAkcija.getProject();
            newNode = factory.createNode(null,project.getIme(),project.getAutor(),project.getPutanja());
        }

        else if(selectedNode instanceof Project){
            NoviBuildingRoomAkcija noviBuildingRoomAkcija = MainFrame.getInstanca().getActionManager().getNoviBuildingRoomAkcija();
            DraftNode tempDraftTree = noviBuildingRoomAkcija.getDraftNode();
            if(tempDraftTree instanceof Building)
                factory = new FactoryBuilding();
            else
                factory = new FactoryRoom();
            newNode = factory.createNode(selectedNode,tempDraftTree.getIme(),"","");
        }

        else{
            NoviRoomAkcija noviRoomAkcija = MainFrame.getInstanca().getActionManager().getNoviRoomAkcija();
            Room room = noviRoomAkcija.getRoom();
            factory = new FactoryRoom();
            newNode = new Room(room.getIme(),selectedNode);
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

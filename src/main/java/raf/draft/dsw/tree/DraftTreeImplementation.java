package raf.draft.dsw.tree;

import lombok.Getter;
import lombok.Setter;
import raf.draft.dsw.controller.actions.*;
import raf.draft.dsw.controller.observer.IPublisher;
import raf.draft.dsw.controller.observer.ISubscriber;
import raf.draft.dsw.controller.observer.Notification;
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
import raf.draft.dsw.utils.ColorUtils;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Getter
@Setter
public class DraftTreeImplementation implements DraftTree, IPublisher {
    private DraftTreeView treeView;
    private DefaultTreeModel treeModel;
    private ArrayList<ISubscriber> subscriberList = new ArrayList<>();
    private DraftNode selektovaniProjekat;

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
        Notification notification = null;
        if (selectedTreeItem == null) {
            Message messsage = new Message(MessageType.GRESKA, LocalDateTime.now(),"Nije selektovana grana!");
            ApplicationFramework.getInstanca().getMessageGenerator().generateMessage(messsage);
            return;
        }
        if(!(selectedTreeItem.getDraftNode() instanceof DraftNodeComposite)){
            Message messsage = new Message(MessageType.GRESKA, LocalDateTime.now(),"Soba ne moze da ima dete");
            ApplicationFramework.getInstanca().getMessageGenerator().generateMessage(messsage);
            return;
        }

        DraftNodeComposite selectedNode = (DraftNodeComposite) selectedTreeItem.getDraftNode();
        DraftNode newNode = null;

        if(selectedNode instanceof ProjectExplorer){
            NoviProjekatAkcija noviProjekatAkcija = MainFrame.getInstanca().getActionManager().getNoviProjekatAkcija();
            Project project = noviProjekatAkcija.getProject();
            newNode = createChild(project);
            newNode.setColor(ColorUtils.randomColor());
            if(selektovaniProjekat == null){
                selektovaniProjekat = newNode;
                notification = new Notification(new Message(null,null,"selekcijaProjekta"));
            }

        }

        else if(selectedNode instanceof Project){
            NoviBuildingRoomAkcija noviBuildingRoomAkcija = MainFrame.getInstanca().getActionManager().getNoviBuildingRoomAkcija();
            DraftNode tempDraftTree = noviBuildingRoomAkcija.getDraftNode();
            if(tempDraftTree == null)
                return;
            if(tempDraftTree instanceof Room){

                Dimension d = noviBuildingRoomAkcija.getDimenzijaSobe();
                if(d==null)
                {
                    Message messsage = new Message(MessageType.GRESKA, LocalDateTime.now(),"pogresno uneta dimenzija");
                    ApplicationFramework.getInstanca().getMessageGenerator().generateMessage(messsage);
                    return;
                }
                ((Room)tempDraftTree).setDimenzija(d);
            }
            newNode = createChild(tempDraftTree);
            if(tempDraftTree instanceof Building)
                newNode.setColor(ColorUtils.randomColor());
            else
                newNode.setColor(newNode.getRoditelj().getColor());
        }

        else{ //Building

            NoviRoomAkcija noviRoomAkcija = MainFrame.getInstanca().getActionManager().getNoviRoomAkcija();
            Room room = noviRoomAkcija.getRoom();
            newNode = createChild(room);
            newNode.setColor(newNode.getRoditelj().getColor());

        }

        if(selectedNode.getChildren().contains(newNode)){
            Message messsage = new Message(MessageType.GRESKA, LocalDateTime.now(),"Greska pri imenovanju!");
            ApplicationFramework.getInstanca().getMessageGenerator().generateMessage(messsage);
            return;
        }

        selectedNode.addChild(newNode);
        selectedTreeItem.add(new DraftTreeItem(newNode));

        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
        notifySubscribers(notification);
    }

    @Override
    public void removeChild() {
        DraftTreeItem selectedTreeItem = getSelectedNode();
        if(selectedTreeItem==null){
            Message messsage = new Message(MessageType.GRESKA, LocalDateTime.now(),"Nema selectovan cvor za brisanje!");
            ApplicationFramework.getInstanca().getMessageGenerator().generateMessage(messsage);
            return;
        }
        else if(selectedTreeItem.getDraftNode() instanceof ProjectExplorer){
            Message messsage = new Message(MessageType.GRESKA, LocalDateTime.now(),"Ne moze da se obrise root!");
            ApplicationFramework.getInstanca().getMessageGenerator().generateMessage(messsage);
        }
        selectedTreeItem.removeFromParent();
        ((DraftNodeComposite)selectedTreeItem.getDraftNode().getRoditelj()).removeChild(selectedTreeItem.getDraftNode());

        SwingUtilities.updateComponentTreeUI(treeView);
        notifySubscribers(null);
    }

    @Override
    public void editSelectedNode() {
        DraftTreeItem selectedTreeItem = getSelectedNode();
        if(selectedTreeItem.getDraftNode() instanceof Project)
        {
            EditProjekatAkcija editRoomAkcija = MainFrame.getInstanca().getActionManager().getEditProjekatAkcija();
            editRoomAkcija.setProjekat();
            notifySubscribers(null);
        }
        else if(selectedTreeItem.getDraftNode() instanceof Building)
        {
            EditBuildingAkcija editBuildingAkcija = MainFrame.getInstanca().getActionManager().getEditBuildingAkcija();
            editBuildingAkcija.setBuilding();
            notifySubscribers(null);
        }
        else{
            EditRoomAkcija editRoomAkcija = MainFrame.getInstanca().getActionManager().getEditRoomAkcija();
            editRoomAkcija.setRoom();
            notifySubscribers(null);
        }
        SwingUtilities.updateComponentTreeUI(treeView);
    }


    @Override
    public DraftTreeItem getSelectedNode() {
        return (DraftTreeItem) treeView.getLastSelectedPathComponent();
    }

    private DraftNode createChild(DraftNode draftNode) {
        Factory factory;
        if(draftNode instanceof Project){
            Project project = (Project) draftNode;
            factory = new FactoryProject();
            DraftNode newNode = factory.createNode(getSelectedNode().getDraftNode(),project.getNaziv(),project.getAutor(),project.getPutanja(),null );
            newNode.setRoditelj(getSelectedNode().getDraftNode());
            return newNode;
        }
        Dimension dimenzija = null;
        if(draftNode instanceof Building)
            factory = new FactoryBuilding();
        else{
            factory = new FactoryRoom();
            dimenzija = ((Room)draftNode).getDimenzija();
        }
        DraftNode newNode = factory.createNode(getSelectedNode().getDraftNode(),draftNode.getNaziv(),"","",dimenzija);
        newNode.setRoditelj(getSelectedNode().getDraftNode());
        return newNode;
    }

    @Override
    public void addSubscriber(ISubscriber sub) {
        subscriberList.add(sub);
    }

    @Override
    public void removeSubscriber(ISubscriber sub) {
        subscriberList.remove(sub);
    }
    @Override
    public void notifySubscribers(Notification notification) {
        for(ISubscriber subscriber : subscriberList) {
            subscriber.update(notification);
        }
    }
}

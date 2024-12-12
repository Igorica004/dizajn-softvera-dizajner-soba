package raf.draft.dsw.controller.actions;

import lombok.Data;
import raf.draft.dsw.controller.actions.StateActions.*;
import raf.draft.dsw.state.concrete.EditElementState;

@Data
public class ActionManager {
    private ExitAction exitAction;
    private ONamaAkcija oNamaAkcija;
    private NoviCvorAkcija noviCvorAkcija;
    private NoviProjekatAkcija noviProjekatAkcija;
    private NoviBuildingRoomAkcija noviBuildingRoomAkcija;
    private NoviRoomAkcija noviRoomAkcija;
    private BrisanjeAkcija brisanjeAkcija;
    private EditRoomAkcija editRoomAkcija;
    private EditBuildingAkcija editBuildingAkcija;
    private EditProjekatAkcija editProjekatAkcija;
    private EditCvorAkcija editCvorAkcija;
    private AddStateAction addStateAction;
    private EditRoomStateAction editRoomStateAction;
    private MoveStateAction moveStateAction;
    private ResizeStateAction resizeStateAction;
    private SelectStateAction selectStateAction;
    private RotateStateAction rotateStateAction;
    private KopiranjeElementaAkcija kopiranjeElementaAkcija;
    private PasteElementaAkcija pasteElementaAkcija;
    private EditElementStateAction editElementStateAction;
    public ActionManager(){
        exitAction = new ExitAction();
        oNamaAkcija = new ONamaAkcija();
        noviCvorAkcija = new NoviCvorAkcija();
        noviProjekatAkcija = new NoviProjekatAkcija();
        noviBuildingRoomAkcija = new NoviBuildingRoomAkcija();
        noviRoomAkcija = new NoviRoomAkcija();
        brisanjeAkcija = new BrisanjeAkcija();
        editRoomAkcija = new EditRoomAkcija();
        editBuildingAkcija = new EditBuildingAkcija();
        editProjekatAkcija = new EditProjekatAkcija();
        editCvorAkcija = new EditCvorAkcija();
        addStateAction = new AddStateAction();
        editRoomStateAction = new EditRoomStateAction();
        moveStateAction = new MoveStateAction();
        resizeStateAction = new ResizeStateAction();
        selectStateAction = new SelectStateAction();
        rotateStateAction = new RotateStateAction();
        kopiranjeElementaAkcija = new KopiranjeElementaAkcija();
        pasteElementaAkcija = new PasteElementaAkcija();
        editElementStateAction = new EditElementStateAction();
    }

}

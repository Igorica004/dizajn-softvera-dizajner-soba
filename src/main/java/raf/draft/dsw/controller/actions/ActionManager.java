package raf.draft.dsw.controller.actions;

import lombok.Data;

@Data
public class ActionManager {
    private ExitAction exitAction;
    private ONamaAkcija oNamaAkcija;
    private NoviCvorAkcija noviCvorAkcija;
    private NoviProjekatAkcija noviProjekatAkcija;
    private NoviBuildingRoomAkcija noviBuildingRoomAkcija;
    private NoviRoomAkcija noviRoomAkcija;
    public ActionManager(){
        exitAction = new ExitAction();
        oNamaAkcija = new ONamaAkcija();
        noviCvorAkcija = new NoviCvorAkcija();
        noviProjekatAkcija = new NoviProjekatAkcija();
        noviBuildingRoomAkcija = new NoviBuildingRoomAkcija();
        noviRoomAkcija = new NoviRoomAkcija();
    }

}

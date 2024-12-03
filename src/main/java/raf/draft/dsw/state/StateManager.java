package raf.draft.dsw.state;

import lombok.Getter;
import raf.draft.dsw.state.Concrete.*;

@Getter
public class StateManager {
    State currentState;
    AddState addState;
    EditRoomState editRoomState;
    MoveState moveState;
    ResizeState resizeState;
    SelectState selectState;

    public StateManager() {
        initializeStates();
    }
    private void initializeStates() {
        addState = new AddState();
        editRoomState = new EditRoomState();
        moveState = new MoveState();
        resizeState = new ResizeState();
        selectState = new SelectState();
    }

    public void setAddState() {currentState = addState;}
    public void setEditRoomState() {currentState = editRoomState;}
    public void setMoveState() {currentState = moveState;}
    public void setResizeState() {currentState = resizeState;}
    public void setSelectState() {currentState = selectState;}

}

package raf.draft.dsw.state;

import lombok.Getter;
import raf.draft.dsw.state.concrete.*;

@Getter
public class StateManager {
    State currentState;
    AddState addState;
    EditRoomState editRoomState;
    MoveState moveState;
    ResizeState resizeState;
    SelectState selectState;
    RotateState rotateState;
    DeleteState deleteState;
    EditElementState editElementState;
    public StateManager() {
        initializeStates();
    }
    private void initializeStates() {
        addState = new AddState();
        editRoomState = new EditRoomState();
        moveState = new MoveState();
        resizeState = new ResizeState();
        selectState = new SelectState();
        rotateState = new RotateState();
        deleteState = new DeleteState();
        editElementState = new EditElementState();
    }

    public void setAddState() {currentState = addState;}
    public void setEditRoomState() {currentState = editRoomState;}
    public void setMoveState() {currentState = moveState;}
    public void setResizeState() {currentState = resizeState;}
    public void setSelectState() {currentState = selectState;}
    public void setRotateState() {currentState = rotateState;}
    public void setDeleteState() {currentState = deleteState;}
    public void setEditElementState() {currentState = editElementState;}
}

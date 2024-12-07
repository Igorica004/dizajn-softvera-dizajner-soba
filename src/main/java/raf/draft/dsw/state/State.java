package raf.draft.dsw.state;

import raf.draft.dsw.model.roomobjects.RoomElement;

public interface State {
    void misPrevucen();
    void misOtpusten();
    void misSkrolGore();
    void misSkrolDole();
}

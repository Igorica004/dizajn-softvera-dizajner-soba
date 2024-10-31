package raf.draft.dsw.controller.observer;

import lombok.AllArgsConstructor;
import lombok.Data;
import raf.draft.dsw.model.messages.Message;

@Data
@AllArgsConstructor
public class Notification {
    private Message poruka;
}

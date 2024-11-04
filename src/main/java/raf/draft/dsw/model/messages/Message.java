package raf.draft.dsw.model.messages;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Message {
    private MessageType tipPoruke;
    private LocalDateTime timestamp;
    private String sadrzaj;

    @Override
    public String toString() {
        return String.format("[%s][%s] %s",tipPoruke,timestamp,sadrzaj);
    }
}

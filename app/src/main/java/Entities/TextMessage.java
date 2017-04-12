package Entities;

/**
 * Created by Omar Hezi on 12/04/17.
 */

public class TextMessage implements BaseMessage {
    private String messageContents;

    public TextMessage(String messageContents) {
        this.messageContents = messageContents;
    }

    public String getMessageContents() {
        return messageContents;
    }

    public void setMessageContents(String messageContents) {
        this.messageContents = messageContents;
    }
}

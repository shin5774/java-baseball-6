package baseball.controller;

import baseball.view.MessageView;

public class MessageController {
    private final MessageView messageView;

    public MessageController(MessageView messageView) {
        this.messageView = messageView;
    }

    public void displayProgramStartMessage() {
        messageView.displayProgramStartMessage();
    }

    public void displayFinishGameMessage() {
        messageView.displayFinishGameMessage();
    }
}

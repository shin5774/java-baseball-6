package baseball;

import baseball.controller.MessageController;
import baseball.view.MessageView;

public class Application {
    public static void main(String[] args) {
        BaseballApplication baseballApplication = new BaseballApplication(new MessageController(new MessageView()));
        baseballApplication.start();
    }
}

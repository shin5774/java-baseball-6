package baseball;

import baseball.controller.MessageController;
import baseball.view.InputView;
import baseball.view.MessageView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        BaseballApplication baseballApplication = new BaseballApplication(new InputView(), new OutputView(),
                new MessageController(new MessageView()));
        baseballApplication.start();
        baseballApplication.finish();
    }
}

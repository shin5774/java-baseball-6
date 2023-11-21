package baseball;

import baseball.controller.DisplayResultController;
import baseball.controller.GenerateComputerNumbersController;
import baseball.controller.GenerateRoundResultController;
import baseball.controller.MessageController;
import baseball.controller.RequestRestartController;
import baseball.controller.RequestUserNumbersController;
import baseball.model.Numbers;
import baseball.model.Restart;
import baseball.model.Result;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

public class BaseballApplication {
    private final InputView inputView;
    private final OutputView outputView;
    private final MessageController messageController;

    public BaseballApplication(InputView inputView, OutputView outputView, MessageController messageController) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.messageController = messageController;
    }

    public void start() {
        messageController.displayProgramStartMessage();
        playGame();
    }

    private void playGame() {
        Numbers computer = new GenerateComputerNumbersController().proceed();
        playRound(computer);

        Restart restart = new RequestRestartController(inputView).proceed();

        if (restart.isContinue()) {
            playGame();
        }
    }

    private void playRound(Numbers computer) {
        Numbers user = new RequestUserNumbersController(inputView).proceed();
        Result roundResult = new GenerateRoundResultController(computer, user).proceed();

        new DisplayResultController(outputView).proceed(roundResult);
        if (roundResult.isFinish()) {
            messageController.displayFinishGameMessage();
            return;
        }

        playRound(computer);
    }

    public void finish() {
        Console.close();
    }
}

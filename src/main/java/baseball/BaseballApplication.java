package baseball;

import baseball.controller.GenerateComputerNumbersController;
import baseball.controller.GenerateRoundResultController;
import baseball.controller.MessageController;
import baseball.controller.RequestRestartController;
import baseball.controller.RequestUserNumbersController;
import baseball.model.Result;
import baseball.view.InputView;
import baseball.view.OutputView;
import baseball.vo.Numbers;
import baseball.vo.Restart;

public class BaseballApplication {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private final MessageController messageController;

    public BaseballApplication(MessageController messageController) {
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

        outputView.printResult(roundResult.getResult());
        if (roundResult.isThreeStrike()) {
            messageController.displayFinishGameMessage();
            return;
        }

        playRound(computer);
    }
}

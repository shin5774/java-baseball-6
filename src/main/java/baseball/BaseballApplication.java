package baseball;

import baseball.controller.GenerateRoundResultController;
import baseball.model.Game;
import baseball.model.Result;
import baseball.util.Mapper;
import baseball.view.InputView;
import baseball.view.OutputView;
import baseball.vo.Numbers;
import baseball.vo.Restart;

public class BaseballApplication {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    public void start() {
        outputView.printProgramStartMessage();
        startGame();
    }

    private void startGame() {
        Game game = new Game();
        playRound(game);

        Restart restart = Mapper.toRestart(inputView.inputContinue());

        if (restart.isContinue()) {
            startGame();
        }
    }

    private void playRound(Game game) {
        Numbers user = Mapper.toNumbers(inputView.inputNumbers());
        Result roundResult = new GenerateRoundResultController(game.getComputer(), user).proceed();

        outputView.printResult(roundResult.getResult());
        if (roundResult.isThreeStrike()) {
            outputView.printFinishGameMessage();
            return;
        }

        playRound(game);
    }
}

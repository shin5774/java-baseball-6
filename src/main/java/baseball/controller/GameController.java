package baseball.controller;

import baseball.model.Result;
import baseball.service.GameService;
import baseball.util.Mapper;
import baseball.view.InputView;
import baseball.view.OutputView;
import baseball.vo.Numbers;
import baseball.vo.Restart;

public class GameController {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private GameService gameService = new GameService();

    public void startProgram() {
        outputView.printProgramStartMessage();
        startGame();
    }

    private void startGame() {
        startRound();

        if (gameService.isRestart(inputRestart())) {
            startGame();
        }
    }

    private void startRound() {
        Numbers user = inputNumbers();
        Result roundResult = new GenerateRoundResultController(gameService.getComputer(), user).proceed();
        outputView.printResult(roundResult.getResult());

        if (roundResult.isThreeStrike()) {
            outputView.printFinishGameMessage();
            return;
        }
        startRound();
    }

    private Numbers inputNumbers() {
        return Mapper.toNumbers(inputView.inputNumbers());
    }

    private Restart inputRestart() {
        return Mapper.toRestart(inputView.inputContinue());
    }
}
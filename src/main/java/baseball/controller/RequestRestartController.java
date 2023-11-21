package baseball.controller;

import baseball.dto.RestartDto;
import baseball.util.Mapper;
import baseball.view.InputView;
import baseball.model.Restart;

public class RequestRestartController {
    private final InputView inputView;

    public RequestRestartController(InputView inputView) {
        this.inputView = inputView;
    }

    public Restart proceed() {
        RestartDto requestRestart = inputView.inputContinue();
        return Mapper.toRestart(requestRestart);
    }
}

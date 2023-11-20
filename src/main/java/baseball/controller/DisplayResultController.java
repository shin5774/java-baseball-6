package baseball.controller;

import baseball.dto.ResultDto;
import baseball.model.Result;
import baseball.view.OutputView;
import java.util.List;

public class DisplayResultController {
    private final OutputView outputView;

    public DisplayResultController(OutputView outputView) {
        this.outputView = outputView;
    }

    public void proceed(Result result) {
        List<ResultDto> resultStates = result.getResultStates();
        outputView.displayResult(resultStates);
    }
}

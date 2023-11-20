package baseball.controller;

import baseball.dto.NumbersDto;
import baseball.util.Mapper;
import baseball.view.InputView;
import baseball.vo.Numbers;

public class RequestUserNumbersController {
    private final InputView inputView;

    public RequestUserNumbersController(InputView inputView) {
        this.inputView = inputView;
    }

    public Numbers proceed() {
        NumbersDto requestNumbers = inputView.inputNumbers();
        return Mapper.toNumbers(requestNumbers);
    }
}

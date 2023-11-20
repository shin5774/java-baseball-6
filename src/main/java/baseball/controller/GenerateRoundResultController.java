package baseball.controller;

import baseball.model.Result;
import baseball.vo.Numbers;
import baseball.vo.ResultState;
import java.util.List;

public class GenerateRoundResultController {
    private final Numbers computer;
    private final Numbers user;


    public GenerateRoundResultController(Numbers computer, Numbers user) {
        this.computer = computer;
        this.user = user;
    }

    public Result proceed() {
        List<ResultState> resultStates = computer.getResultStates(user);

        return Result.from(resultStates);
    }
}

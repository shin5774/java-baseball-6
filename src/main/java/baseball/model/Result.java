package baseball.model;

import baseball.dto.ResultDto;
import java.util.ArrayList;
import java.util.List;

public class Result {
    private static final int FINISH_SIZE = 3;
    private final int strike;
    private final int ball;

    private Result(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public static Result from(List<ResultState> resultStates) {
        return new Result(findResult(resultStates, ResultState.STRIKE), findResult(resultStates, ResultState.BALL));
    }

    private static int findResult(List<ResultState> resultStates, ResultState resultState) {
        return (int) resultStates.stream().filter(state -> state == resultState)
                .count();
    }

    public List<ResultDto> getResultStates() {
        List<ResultDto> resultStates = new ArrayList<>();
        resultStates.add(new ResultDto(ResultState.BALL, ball));
        resultStates.add(new ResultDto(ResultState.STRIKE, strike));

        return resultStates;
    }

    public boolean isThreeStrike() {
        return strike == FINISH_SIZE;
    }
}
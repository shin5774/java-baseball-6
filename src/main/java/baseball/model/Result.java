package baseball.model;

import static baseball.Constant.BALL;
import static baseball.Constant.NOTHING;
import static baseball.Constant.STRIKE;

import baseball.vo.Numbers;

public class Result {
    private static final int FINISH_SIZE = 3;
    private int strike;
    private int ball;

    public Result(Numbers computer, Numbers user) {
        strike = 0;
        ball = 0;

        for (int index = 0; index < 3; index++) {
            addResult(computer.calculateByIndex(user, index));
        }
    }

    private void addResult(String result) {
        if (result.equals(STRIKE)) {
            strike += 1;
            return;
        }

        if (result.equals(BALL)) {
            ball += 1;
        }
    }

    public String getResult() {
        String resultMessage = "";

        if (ball != 0) {
            resultMessage += ball + BALL + " ";
        }
        if (strike != 0) {
            resultMessage += strike + STRIKE;
        }
        if (resultMessage.equals("")) {
            return NOTHING;
        }

        return resultMessage.strip();
    }

    public boolean isThreeStrike() {
        return strike == FINISH_SIZE;
    }
}
package baseball.controller;

import static baseball.Constant.NUMBER_HIGH_BOUND;
import static baseball.Constant.NUMBER_LOW_BOUND;
import static baseball.Constant.NUMBER_SIZE;

import baseball.vo.Number;
import baseball.model.Numbers;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GenerateComputerNumbersController {
    public Numbers proceed() {
        return toNumbers(generate());
    }

    private Numbers toNumbers(List<Integer> computer) {
        return new Numbers(computer.stream()
                .map(Number::new)
                .toList());
    }

    private List<Integer> generate() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < NUMBER_SIZE) {
            addNumber(computer, pickRandom());
        }

        return computer;
    }

    private int pickRandom() {
        return Randoms.pickNumberInRange(NUMBER_LOW_BOUND, NUMBER_HIGH_BOUND);
    }

    private void addNumber(List<Integer> computer, int randomNumber) {
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber);
        }
    }
}

package baseball.controller;

import static baseball.Constant.NUMBER_SIZE;

import baseball.vo.Number;
import baseball.vo.Numbers;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GenerateComputerNumbersController {
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 9;

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
        return Randoms.pickNumberInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER);
    }

    private void addNumber(List<Integer> computer, int randomNumber) {
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber);
        }
    }
}

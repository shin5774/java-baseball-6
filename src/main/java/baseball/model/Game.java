package baseball.model;

import static baseball.Constant.NUMBER_SIZE;

import baseball.vo.Number;
import baseball.vo.Numbers;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 9;
    private final Numbers computer;

    public Game() {
        computer = new Numbers(generateComputerNumbers());
    }

    private List<Number> generateComputerNumbers() {
        List<Integer> computer = new ArrayList<>();
        generate(computer);

        return computer.stream()
                .map(Number::new)
                .toList();
    }

    private void generate(List<Integer> computer) {
        while (computer.size() < NUMBER_SIZE) {
            int randomNumber = pickRandom();
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    private int pickRandom() {
        return Randoms.pickNumberInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER);
    }

    public Numbers getComputer() {
        return computer;
    }
}

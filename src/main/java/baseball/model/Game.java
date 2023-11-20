package baseball.model;

import static baseball.Constant.NUMBER_SIZE;

import baseball.dto.RoundResult;
import baseball.vo.Numbers;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Game {
    private static final String DELIMITER = "";
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 9;
    private final Numbers computer;

    public Game() {
        computer = new Numbers(generateComputerNumbers());
    }

    private String generateComputerNumbers() {
        Set<String> computer = new HashSet<>();
        generate(computer);

        return toString(computer);
    }

    public RoundResult playRound(Numbers user) {
        return new RoundResult(computer, user);
    }

    private String toString(Set<String> computer) {
        return String.join(DELIMITER, new ArrayList<>(computer));
    }

    private void generate(Set<String> computer) {
        while (computer.size() < NUMBER_SIZE) {
            computer.add(toString(pickRandom()));
        }
    }

    private String toString(int number) {
        return Integer.toString(number);
    }

    private int pickRandom() {
        return Randoms.pickNumberInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER);
    }
}

package baseball.model;

import baseball.vo.Number;
import java.util.List;
import java.util.Objects;

public class Numbers {
    private final List<Number> numbers;

    public Numbers(List<Number> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Number> numbers) {
        int uniqueCount = (int) numbers.stream()
                .distinct().count();

        if (uniqueCount != 3) {
            throw new IllegalArgumentException();
        }
    }

    public List<ResultState> getResultStates(Numbers other) {
        return other.numbers.stream()
                .map(number -> getResultState(other, number))
                .filter(Objects::nonNull)
                .toList();
    }

    private ResultState getResultState(Numbers other, Number number) {
        if (other.getIndex(number) == getIndex(number)) {
            return ResultState.STRIKE;
        }
        if (numbers.contains(number)) {
            return ResultState.BALL;
        }

        return null;
    }

    private int getIndex(Number number) {
        return numbers.indexOf(number);
    }
}

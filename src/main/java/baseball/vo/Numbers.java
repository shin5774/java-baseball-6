package baseball.vo;

import static baseball.Constant.BALL;
import static baseball.Constant.STRIKE;

import java.util.List;

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


    public String calculateByIndex(Numbers other, int index) {
        Number othersNumber = other.numberAt(index);

        if (isSamePlace(othersNumber, index)) {
            return STRIKE;
        }
        if (isExist(othersNumber)) {
            return BALL;
        }
        return "";
    }

    private Number numberAt(int index) {
        return numbers.get(index);
    }

    private boolean isSamePlace(Number number, int index) {
        return numberAt(index).equals(number);
    }

    private boolean isExist(Number number) {
        return numbers.contains(number);
    }
}

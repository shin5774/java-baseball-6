package baseball.vo;

import static baseball.Constant.NUMBER_HIGH_BOUND;
import static baseball.Constant.NUMBER_LOW_BOUND;

import java.util.Objects;

public class Number {
    private final int number;

    public Number(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (isOutOfRange(number)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isOutOfRange(int number) {
        return number < NUMBER_LOW_BOUND || number > NUMBER_HIGH_BOUND;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Number number1 = (Number) object;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}

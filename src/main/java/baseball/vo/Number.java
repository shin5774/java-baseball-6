package baseball.vo;

import java.util.Objects;

public class Number {
    private static final int LOW_BOUND = 1;
    private static final int HIGH_BOUND = 9;
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
        return number < LOW_BOUND || number > HIGH_BOUND;
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

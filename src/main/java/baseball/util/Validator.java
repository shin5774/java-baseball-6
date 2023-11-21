package baseball.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Pattern;

public class Validator {
    private static final Pattern NUMBERS = Pattern.compile("[0-9]+");

    protected static void validateSize(String numbers, int size) {
        if (numbers.length() != size) {
            throw new IllegalArgumentException("값이 " + size + "자리여야 합니다.");
        }
    }

    protected static void validateType(String numbers, String regex) {
        if (!numbers.matches(regex)) {
            throw new IllegalArgumentException("값이 올바르지 않습니다.");
        }
    }

    protected static void validateUnique(String numbers) {
        if (toSet(toArray(numbers)).size() != 3) {
            throw new IllegalArgumentException("값의 중복은 없어야 합니다.");
        }
    }

    private static HashSet<String> toSet(String[] numbers) {
        return new HashSet<>(Arrays.asList(numbers));
    }

    private static String[] toArray(String numbers) {
        return numbers.split("");
    }

    public static void isInteger(String numbers) {
        if (!NUMBERS.matcher(numbers).matches()) {
            throw new IllegalArgumentException("값이 올바르지 않습니다.");
        }
    }
}

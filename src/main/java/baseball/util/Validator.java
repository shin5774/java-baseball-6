package baseball.util;

import java.util.regex.Pattern;

public class Validator {
    private static final Pattern NUMBERS = Pattern.compile("[0-9]+");

    public static void isInteger(String numbers) {
        if (!NUMBERS.matcher(numbers).matches()) {
            throw new IllegalArgumentException("값이 올바르지 않습니다.");
        }
    }
}

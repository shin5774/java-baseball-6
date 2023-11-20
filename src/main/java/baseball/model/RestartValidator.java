package baseball.model;

import static baseball.Constant.RESTART_SIZE;

public class RestartValidator extends Validator {
    public static void validate(String input) {
        validateSize(input, RESTART_SIZE);
        validateType(input, "[1-2]+");
    }
}

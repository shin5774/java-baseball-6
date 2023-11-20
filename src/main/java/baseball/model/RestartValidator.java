package baseball.model;

import static baseball.Constant.RESTART_SIZE;

public class RestartValidator extends Validator {
    @Override
    public void validate(String input) {
        validateSize(input, RESTART_SIZE);
        validateType(input, "[1-2]+");
    }
}

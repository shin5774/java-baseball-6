package baseball.vo;

import baseball.model.RestartValidator;
import baseball.model.Validator;

public class Restart {
    private static final String CONTINUE_KEY = "1";
    private final String option;

    public Restart(String input) {
        Validator validator = new RestartValidator();
        validator.validate(input);

        option = input;
    }

    public boolean isContinue() {
        return option.equals(CONTINUE_KEY);
    }

}

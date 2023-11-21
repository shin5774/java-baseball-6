package baseball.model;

public class Restart {
    private static final String CONTINUE_KEY = "1";
    private static final String FINISH_KEY = "2";
    private static final int OPTION_SIZE = 1;
    private final String option;

    public Restart(String input) {
        validate(input);
        option = input;
    }

    private void validate(String input) {
        if (input.length() != OPTION_SIZE) {
            throw new IllegalArgumentException();
        }

        if (isNotRestartKey(input)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isNotRestartKey(String input) {
        return !(input.equals(CONTINUE_KEY) || (input.equals(FINISH_KEY)));
    }
    
    public boolean isContinue() {
        return option.equals(CONTINUE_KEY);
    }

}

package baseball.model;

import static baseball.Constant.NUMBER_SIZE;

public class NumbersValidator extends Validator {
    @Override
    public void validate(String numbers) {
        validateSize(numbers, NUMBER_SIZE);
        validateType(numbers, "[1-9]+");
        validateUnique(numbers);
    }
}

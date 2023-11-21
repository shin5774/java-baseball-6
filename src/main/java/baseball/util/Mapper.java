package baseball.util;

import baseball.dto.NumbersDto;
import baseball.dto.RestartDto;
import baseball.vo.Number;
import baseball.model.Numbers;
import baseball.model.Restart;
import java.util.Arrays;
import java.util.List;

public class Mapper {
    private static final String NUMBERS_DELIMITER = "";

    public static NumbersDto toNumbersDto(String numbers) {
        Validator.isInteger(numbers);

        return new NumbersDto(toList(numbers));
    }

    private static List<String> toList(String numbers) {
        return Arrays.stream(numbers.split(NUMBERS_DELIMITER))
                .toList();
    }

    public static Numbers toNumbers(NumbersDto numbersDto) {
        List<Number> numbers = numbersDto.numbers().stream()
                .map(Integer::parseInt)
                .map(Number::new)
                .toList();

        return new Numbers(numbers);
    }

    public static RestartDto toRestartDto(String request) {
        Validator.isInteger(request);

        return new RestartDto(request);
    }

    public static Restart toRestart(RestartDto restartDto) {
        return new Restart(restartDto.request());
    }
}

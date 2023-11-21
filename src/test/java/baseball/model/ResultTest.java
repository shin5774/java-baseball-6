package baseball.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import baseball.vo.Number;
import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ResultTest {
    @DisplayName("결과 값 문자열 반환 기능")
    @ParameterizedTest
    @CsvSource(value = {"134:1볼 1스트라이크", "456:낫싱", "345:1볼", "157:1스트라이크"}, delimiter = ':')
    void 결과_문자열_반환(String numbers, String expected) {
        Numbers computer = new Numbers(Stream.of(1, 2, 3)
                .map(Number::new)
                .toList());
        Numbers user = new Numbers(Arrays.stream(numbers.split(""))
                .map(Integer::parseInt)
                .map(Number::new)
                .toList());

        Result result = Result.from(computer.getResultStates(user));

        assertThat(result.getResult()).isEqualTo(expected);
    }

    @DisplayName("3스트라이크 확인 기능")
    @ParameterizedTest
    @ValueSource(strings = {"123", "234", "135", "974", "245"})
    void 쓰리스트라이크_확인(String numbers) {
        Numbers user = new Numbers(Arrays.stream(numbers.split(""))
                .map(Integer::parseInt)
                .map(Number::new)
                .toList());
        Result result = Result.from(user.getResultStates(user));

        assertThat(result.isThreeStrike()).isTrue();
    }
}

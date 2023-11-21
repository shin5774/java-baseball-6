package baseball.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import baseball.vo.Number;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ResultTest {
    @DisplayName("3스트라이크 확인 기능")
    @ParameterizedTest
    @ValueSource(strings = {"123", "234", "135", "974", "245"})
    void 쓰리스트라이크_확인(String numbers) {
        Numbers user = new Numbers(Arrays.stream(numbers.split(""))
                .map(Integer::parseInt)
                .map(Number::new)
                .toList());
        Result result = Result.from(user.getResultStates(user));

        assertThat(result.isFinish()).isTrue();
    }
}

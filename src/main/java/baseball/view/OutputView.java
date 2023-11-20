package baseball.view;

import baseball.dto.ResultDto;
import java.util.List;
import java.util.StringJoiner;

public class OutputView {
    private static final String NOT_EXIST = "낫싱";
    private static final String JOINER_DELIMITER = " ";

    public void displayResult(List<ResultDto> resultStates) {
        System.out.println(getResult(resultStates));
    }

    private String getResult(List<ResultDto> resultStates) {
        StringJoiner result = new StringJoiner(JOINER_DELIMITER);

        resultStates.stream()
                .filter(resultDto -> resultDto.count() != 0)
                .forEach(resultDto -> result.add(resultDto.count() + resultDto.resultState().getTitle()));

        if (result.length() == 0) {
            return NOT_EXIST;
        }

        return result.toString();
    }
}

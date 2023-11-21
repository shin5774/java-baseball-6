package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.dto.NumbersDto;
import baseball.dto.RestartDto;
import baseball.util.Mapper;

public class InputView {
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String INPUT_CONTINUE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public NumbersDto inputNumbers() {
        System.out.print(INPUT_NUMBER_MESSAGE);
        return Mapper.toNumbersDto(readLine());
    }

    public RestartDto inputContinue() {
        System.out.println(INPUT_CONTINUE_MESSAGE);
        return Mapper.toRestartDto(readLine());
    }

}

package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String INPUT_CONTINUE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public String inputNumbers() {
        System.out.print(INPUT_NUMBER_MESSAGE);
        return input();
    }

    public String inputContinue() {
        System.out.println(INPUT_CONTINUE_MESSAGE);
        return input();
    }

    private String input() {
        return readLine();
    }
}

package baseball.service;

import baseball.model.Game;
import baseball.vo.Numbers;
import baseball.vo.Restart;

public class GameService {
    private Game game;

    public boolean isRestart(Restart restart) {
        return restart.isContinue();
    }

    public Numbers getComputer() {
        return game.getComputer();
    }
}

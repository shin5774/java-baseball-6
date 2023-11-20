package baseball.vo;

public enum ResultState {
    STRIKE("스트라이크"),
    BALL("볼");

    private final String title;

    ResultState(String title) {
        this.title = title;
    }
}

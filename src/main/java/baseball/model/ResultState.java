package baseball.model;

public enum ResultState {
    STRIKE("스트라이크"),
    BALL("볼");

    private final String title;

    ResultState(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

package baseball.dto;

import baseball.model.ResultState;

public record ResultDto(ResultState resultState, int count) {
}

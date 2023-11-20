package baseball.dto;

import baseball.vo.ResultState;

public record ResultDto(ResultState resultState, int count) {
}

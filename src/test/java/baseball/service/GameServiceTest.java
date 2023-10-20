package baseball.service;

import baseball.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


public class GameServiceTest {

    /*
    @DisplayName("값 비교 테스트")
    @Test
    void ValueCompareTest(){
        //given
        Com com=new Com("713");//컴퓨터의 값
        User user=new User("123");//사용자의 값
        //when
        user.compareAndRefresh(com.numbers.getNumbers());
        //then
        assertThat(user.equalsPoint(new Point(1,1))).isTrue();

    }


    @DisplayName("3 스트라이크 여부 확인 테스트")
    @Test
    void ThreeStrikeTest(){
        String value="123";
        //given
        User user=new User(value);

        //when
        user.compareAndRefresh(value);

        //then
        assertThat(user.isThreeStrike()).isTrue();
    }
    @DisplayName("1번 기능(사용자 값 입력)의 예외처리 기능")
    @ParameterizedTest
    @ValueSource(strings={"1234","12","1a2","zxc","ab2","2ab","112","111","344"})
    void 사용자_입력_기능_예외처리_1번(String values){
        //given
        Validation validation=new Validation();

        //when & then
        assertThat(validation.gameValue(values)).isFalse();
    }

    @DisplayName("게임의 값의 예외처리 기능")
    @ParameterizedTest
    @ValueSource(strings={"1234","12","1a2","zxc","ab2","2ab","112","111","344"})
    void 값_예외처리(String numbers){
        assertThatThrownBy(()->new Numbers(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
    /*
    @DisplayName("컴퓨터의 값을 생성하는 기능")
    @Test
    void 컴퓨터_값_생성_기능(){
        //given
        Game game=new Game();
        Validation validation=new Validation();

        //when
        String comValue=game.generateComValue();

        //then
        assertThat(validation.gameValue(comValue)).isTrue();
    }


    @DisplayName("5번 기능(재시작여부 값 입력)의 예외처리 기능")
    @ParameterizedTest
    @ValueSource(strings={"12","231","4532","D","c","ab","c6","4a","zxs"})
    void 사용자_입력_기능_예외처리_5번(String values){
        //given
        Validation validation=new Validation();

        //when & then
        assertThat(validation.continueValue(values)).isFalse();
    }
     */

    @DisplayName("Game클래스를 통한 com과 user의 numbers 비교 기능")
    @ParameterizedTest
    @ValueSource(strings={"123","231","532"})
    void game_통합_과정(String input){
        //given
        Game game=new Game();

        //when
        int [] gameResult=game.inputAndCompare(input);

        //then
        for(int result :gameResult){
            assertThat(result).isBetween(0,3);
        }
    }

}

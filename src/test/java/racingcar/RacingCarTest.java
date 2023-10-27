package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingCarTest {
    @ParameterizedTest
    @DisplayName("정상적인 이름인 경우 레이싱카가 생성된다")
    @ValueSource(strings = {"a", "ab", "aab", "qwer", "happy"})
    public void createRacingCar(String name){
        assertDoesNotThrow(() -> {
            new RacingCar(name);
        });
    }

    @ParameterizedTest
    @DisplayName("이름이 범위를 초과하는 경우 예외가 발생한다")
    @ValueSource(strings = {"hellow", "helloworld", "m y n a", "meisaz", "1     "})
    public void createExceedingRacingCarName(){
        String name = "abcdef";
        assertThrows(IllegalArgumentException.class, () -> {
            new RacingCar(name);
        });
    }

    @Test
    @DisplayName("이름이 빈 문자열인 경우 예외가 발생한다")
    public void createEmptyRacingCarName(){
        String name = "";
        assertThrows(IllegalArgumentException.class, () -> {
            new RacingCar(name);
        });
    }
}
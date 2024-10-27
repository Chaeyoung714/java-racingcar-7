package racingcar.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;

public class CarsValidatorTest {
    @Test
    void 차_개수가_1개_이하면_예외() {
        String testName = "pobi";
        Validator<List<Car>> validator = new CarsValidator();
        List<Car> cars = new ArrayList<>(
                Arrays.asList(new Car(testName))
        );

        assertThatThrownBy(() -> validator.validate(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Exceptions.INSUFFICIENT_CARS.getMsg());
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,holy,pobi", "w  w,pass,w  w"})
    @DisplayName("이름 3개가 주어지고 1번째 이름과 3번째 이름이 중복될 때, 3번째 이름에서 예외가 발생한다.")
    void 중복_이름이면_예외(String testName) {
        String[] testNames = testName.split(",", -1);
        String testName1 = testNames[0];
        String testName2 = testNames[1];
        String testName3 = testNames[2];
        Validator<List<Car>> validator = new CarsValidator();
        List<Car> cars = new ArrayList<>(
                Arrays.asList(new Car(testName1), new Car(testName2), new Car(testName3))
        );

        assertThatThrownBy(() -> validator.validate(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복되지 않은 이름을 입력해주세요.");
    }
}
package model;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


public class CarTest {

    @Test
    void isCreateCarFromNameList_ShouldReturnSplitCarList(){
        String carString="pobi,crong,honux";
        String[] split = carString.split(",");
        List<Car> carList = Car.createCarFromNameList(split);

        List<Car> expectedCarList = new ArrayList<>();
        expectedCarList.add(new Car("pobi", Car.START_SCORE));
        expectedCarList.add(new Car("crong", Car.START_SCORE));
        expectedCarList.add(new Car("honux", Car.START_SCORE));

        assertThat(carList).isEqualTo(expectedCarList);
    }

    @Test
    void isCar_ShouldThrowIllegalArgumentExceptionWithOverFive(){
        String carStr="longNamehaha";

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                new Car(carStr, 0);
            }).withMessage("차량 이름은 5자를 넘어서는 안됩니다.");
    }

    @Test
    void isCreateCarFromNameList_ShouldThrowIllegalArgumentExceptionWithDuplicateName(){
        String carStr="a,a,a";

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                Car.createCarFromNameList(carStr.split(","));
            }).withMessage("동일 이름은 사용 불가능합니다.");
    }
}

package model;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class CarFactoryTest {
    @Test
    void isCreateCarFromNameList_ShouldReturnSplitCarList(){
        String carString="pobi,crong,honux";
        String[] split = carString.split(",");
        List<Car> carList = CarFactory.createCarFromNameList(List.of(split));

        List<Car> expectedCarList = new ArrayList<>();
        expectedCarList.add(new Car("pobi", CarFactory.START_SCORE));
        expectedCarList.add(new Car("crong", CarFactory.START_SCORE));
        expectedCarList.add(new Car("honux", CarFactory.START_SCORE));

        assertThat(carList).isEqualTo(expectedCarList);
    }

    @Test
    void isCreateCarFromNameList_ShouldThrowIllegalArgumentExceptionWithDuplicateName(){
        String carStr="a,a,a";
        String[] split = carStr.split(",");

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                CarFactory.createCarFromNameList(List.of(split));
            }).withMessage("동일 이름은 사용 불가능합니다.");
    }
}
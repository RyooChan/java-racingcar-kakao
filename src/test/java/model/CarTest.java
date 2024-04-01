package model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


public class CarTest {

    @Test
    void isCar_ShouldThrowIllegalArgumentExceptionWithOverFive(){
        String carStr="longNamehaha";

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                new Car(carStr, 0);
            }).withMessage("차량 이름은 5자를 넘어서는 안됩니다.");
    }

}

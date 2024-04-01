package model;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;

class RaceTest {

    @Test
    void isGetWinner_ShouldReturnMaxCountCarList() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("first", 5));
        carList.add(new Car("sec", 4));
        carList.add(new Car("third", 5));
        carList.add(new Car("firth", 2));

        List<Car> expectedWinner = new ArrayList<>();;
        expectedWinner.add(new Car("first", 5));
        expectedWinner.add(new Car("third", 5));

        Race race = new Race(carList);
        List<Car> winnerList = race.getWinner();
        assertThat(winnerList).isEqualTo(expectedWinner);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void isMoveCar_ShouldIncreaseScoreGreaterOrEqualWithFour(int num) {
        Car car = new Car("name",0);

        CarMove carMove = new CarMove() {
            @Override
            public int move() {
                return num;
            }
        };

        Race race = new Race(of(car));
        race.moveCar(carMove);

        Car expectedCar = new Car("name", 1);
        assertThat(car).isEqualTo(expectedCar);
    }


    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void isMoveCar_ShouldNotIncreaseScoreLessOrEqualWithThree(int num) {
        Car car = new Car("name",0);

        CarMove carMove = new CarMove() {
            @Override
            public int move() {
                return num;
            }
        };

        Race race = new Race(of(car));
        race.moveCar(carMove);

        Car expectedCar = new Car("name", 0);
        assertThat(car).isEqualTo(expectedCar);
    }
}
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
    void isUpdateCarScore_ShouldIncreaseScoreGreaterOrEqualWithFour(int num) {
        Car car = new Car("name",0);
        int expectedScore = 1;

        Race race = new Race(of(car));
        race.updateCarByNum(of(num));
        assertThat(car.getScore()).isEqualTo(expectedScore);
    }


    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void isUpdateCarScore_ShouldNotIncreaseScoreLessOrEqualWithThree(int num) {
        Car car = new Car("name",0);
        int expectedScore = 0;

        Race race = new Race(of(car));
        race.updateCarByNum(of(num));
        assertThat(car.getScore()).isEqualTo(expectedScore);
    }

    @Test
    void isUpdateCarList_ShouldReturnCarListWithUpdatedScore() {
        List<Integer> randomNumList = new ArrayList<>();
        randomNumList.add(4);
        randomNumList.add(2);
        randomNumList.add(7);

        List<Car> carList = new ArrayList<>();
        carList.add(new Car("pobi", 0));
        carList.add(new Car("crong", 0));
        carList.add(new Car("honux", 0));

        Race race = new Race(carList);
        race.updateCarByNum(randomNumList);

        List<Car> expectedCarList = new ArrayList<>();
        expectedCarList.add(new Car("pobi", 1));
        expectedCarList.add(new Car("crong", 0));
        expectedCarList.add(new Car("honux", 1));

        assertThat(carList).isEqualTo(expectedCarList);
    }
}
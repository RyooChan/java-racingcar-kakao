package model;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static model.Car.START_SCORE;

public class Race {
    private List<Car> carList = new ArrayList<>();

    public Race(List<Car> carList) {
        this.carList = carList;
    }

    public List<Car> getWinner() {
        int maxScore = getMaxScore();

        return this.carList
            .stream()
            .filter(car -> isMaxScoreCar(car, maxScore))
            .collect(toList());
    }

    public boolean isMaxScoreCar(Car car, int maxScore) {
        return car.getScore() == maxScore;
    }

    private int getMaxScore() {
        return this.carList
            .stream()
            .map(Car::getScore)
            .max(Integer::compareTo)
            .orElse(START_SCORE);
    }

    public void updateCarByNum(List<Integer> randomNumList) {
        for (int i=0; i<randomNumList.size(); i++) {
            this.carList.get(i).updateCarScore(randomNumList.get(i));
        }
    }

}

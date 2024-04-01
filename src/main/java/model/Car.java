package model;

import java.util.Objects;

public class Car {
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int CAR_MOVE_NUM = 3;
    private int score;
    private final String name;

    public Car(String name, int score) {
        validateCarNameLength(name);
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("차량 이름은 5자를 넘어서는 안됩니다.");
        }
    }

    public void updateCarScore(int randomNum) {
        if (randomNum > CAR_MOVE_NUM){
            this.score++;
        }
    }

    public static String makeCarPrint(Car car) {

        return car.getName() +
            " : " +
            makeDash(car.getScore());
    }

    private static String makeDash(int carScore) {
        String dash = "-";
        return dash.repeat(carScore);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;

        return score == car.score && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(score, name);
    }
}

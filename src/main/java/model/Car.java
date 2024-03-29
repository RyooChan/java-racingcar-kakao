package model;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

import static java.util.Arrays.*;
import static java.util.stream.Collectors.toList;

public class Car {
    private static HashSet<String> DISTINCT_NAME_SET = new HashSet<>();
    public static final int START_SCORE = 1;
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

    public static List<Car> createCarFromNameList(String[] carNameList) {
        DISTINCT_NAME_SET = new HashSet<>();

        return stream(carNameList)
            .map(carName -> {
                validateCarNameDuplicate(carName);
                return new Car(carName, START_SCORE);
            })
            .collect(toList());
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("차량 이름은 5자를 넘어서는 안됩니다.");
        }
    }

    public static void validateCarNameDuplicate(String carName) {
        if (DISTINCT_NAME_SET.contains(carName)) {
            throw new IllegalArgumentException("동일 이름은 사용 불가능합니다.");
        }

        DISTINCT_NAME_SET.add(carName);
    }

    public void updateCarScore(int randomNum) {
        if (randomNum > 3){
            this.score++;
        }
    }

    public static String makeCarPrint(Car car) {
        String stringBuilder = car.getName() +
            " : " +
            makeDash(car.getScore());

        return stringBuilder;
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

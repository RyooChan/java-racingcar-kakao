package view;

import java.util.List;
import java.util.StringJoiner;

import model.Car;

public class ResultView {
    public static void printCars(List<Car> carList) {
        carList.forEach(
            car -> System.out.println(
                car.getName() +
                " : " +
                "-".repeat(car.getScore())
            )
        );
        System.out.println();
    }

    public static void printWinners(List<String> carNameList) {
        StringJoiner joiner = new StringJoiner(",");
        for (String carName : carNameList) {
            joiner.add(carName);
        }

        System.out.println(joiner + " 가 최종 우승했습니다.");
    }

    public static void printGameStart() {
        System.out.println("실행 결과");
    }

}

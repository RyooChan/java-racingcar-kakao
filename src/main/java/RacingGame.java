import java.util.ArrayList;
import java.util.List;

import model.Car;
import model.CarFactory;
import model.CarMove;
import model.Race;

import static java.util.stream.Collectors.*;
import static view.ResultView.printCars;

public class RacingGame {

    private final String carNames;
    private final int tryNo;
    private int gameCount;

    public static List<Car> carList = new ArrayList<>();

    public RacingGame(String carNames, int tryNo) {
        this.carNames = carNames;
        this.tryNo = tryNo;
        createCar();
        printCars(carList);
    }

    private void createCar() {
        String[] split = carNames.split(",");
        carList = CarFactory.createCarFromNameList(List.of(split));
    }

    public void race() {
        Race race = new Race(carList);
        race.moveCar(new CarMove() {});
        gameCount++;
    }

    public List<Car> getCars() {
        return carList;
    }

    public boolean isEnd() {
        return tryNo == gameCount;
    }

    public List<String> getWinners() {
        Race race = new Race(carList);
        return race.getWinner()
            .stream()
            .map(Car::getName)
            .collect(toList());
    }
}

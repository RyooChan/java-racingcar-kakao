import view.InputView;
import view.ResultView;

public class RacingController {

    public static void play() {
        String carNames = InputView.getCarNames();
        int tryNo = InputView.getTryNo();

        ResultView.printGameStart();
        RacingGame racingGame = new RacingGame(carNames, tryNo);
        ResultView.printCars(racingGame.getCars());

        while(!racingGame.isEnd()) {
            racingGame.race();
            ResultView.printCars(racingGame.getCars());
        }

        ResultView.printWinners(racingGame.getWinners());
    }
}

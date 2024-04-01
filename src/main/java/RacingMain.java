import view.InputView;
import view.ResultView;


public class RacingMain {
    public static void main(String[] args) {
        String carNames = InputView.getCarNames();
        int tryNo = InputView.getTryNo();

        ResultView.printGameStart();
        RacingGame racingGame = new RacingGame(carNames, tryNo);

        while(!racingGame.isEnd()) {
            racingGame.race();
            ResultView.printCars(racingGame.getCars());
        }

        ResultView.printWinners(racingGame.getWinners());
    }
}
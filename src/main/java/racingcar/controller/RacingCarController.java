package racingcar.controller;

import racingcar.factory.CarsFactory;
import racingcar.factory.ControllerFactory;
import racingcar.factory.MoveNumberFactory;
import racingcar.domain.Cars;
import racingcar.domain.MoveNumber;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    public void run() {
        Cars cars = createCars();
        MoveNumber moveNumber = createMoveNumber();
        outputRaceResult(cars, moveNumber);
    }

    private Cars createCars() {
        return CarsFactory.createCars(InputView.inputCarNames());
    }

    private MoveNumber createMoveNumber() {
        return MoveNumberFactory.createMoveNumber(InputView.inputMoveNumber());
    }

    private void outputRaceResult(Cars cars, MoveNumber moveNumber) {
        OutputView.outputRaceStartLine();
        cars.registerObserver(ControllerFactory.createCarsOutputView());
        cars.moveCars(moveNumber.getMoveNumber());
        OutputView.outputRaceFinalResult(cars.findWinnerNames());
    }

}

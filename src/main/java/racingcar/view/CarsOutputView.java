package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;

public class CarsOutputView implements Observer{
    private static final String MOVE_DISTANCE_SYMBOL = "-";

    @Override
    public void update(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(String.format("%s : %s"
                    , car.getName()
                    , MOVE_DISTANCE_SYMBOL.repeat(car.getMoveDistance())));
        }
        System.out.println();
    }
}

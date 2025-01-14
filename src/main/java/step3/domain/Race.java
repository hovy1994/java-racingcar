package step3.domain;

import java.util.List;

public class Race {
    private final RacingCars cars;
    private final RaceRound raceRound;
    private final RaceHistory raceHistory;
    private final CarMovement carMovement;

    public Race(RacingCars cars, RaceRound round, CarMovement carMovement) {
        this.cars = cars;
        this.raceRound = round;
        this.raceHistory = new RaceHistory();
        this.carMovement = carMovement;
    }

    public List<Car> getCars() {
        return cars.getAll();
    }

    public RaceHistory start() {
        for (int round = 0; round < raceRound.getValue(); round++) {
            cars.move(carMovement);
            raceHistory.saveRound(new RacingCars(cars.getAll()));
        }
        return raceHistory;
    }

}

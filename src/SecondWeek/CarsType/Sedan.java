package SecondWeek.CarsType;

import SecondWeek.Cars;

public class Sedan implements Cars {

    public String carColor() {
        return "gray";
    }

    public int dailyRental() {
        return 300;
    }

    public int luggageCapacity() {
        return 586;
    }

    public int monthlyRental() {
        return dailyRental() * 30;
    }
}

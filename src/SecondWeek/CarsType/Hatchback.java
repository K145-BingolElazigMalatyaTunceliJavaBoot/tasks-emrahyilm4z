package SecondWeek.CarsType;

import SecondWeek.Cars;

public class Hatchback extends Cars {
    @Override
    public int getMonthlyRental() {
        System.err.println("Hatchback araç aylık kiralamay yapılmaz");
        return -1;
    }
}

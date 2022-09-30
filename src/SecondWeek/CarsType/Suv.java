package SecondWeek.CarsType;

import SecondWeek.Cars;

public class Suv extends Cars {
    @Override
    public int getMonthlyRental() {
        return super.getMonthlyRental() + (100 / getAge() * 30);
    }
}

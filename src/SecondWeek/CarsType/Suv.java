package SecondWeek.CarsType;

import SecondWeek.Cars;

public class Suv extends Cars {
    private int monthlyRental;

    public int getMonthlyRental() {
        return monthlyRental+ (100 / getAge() * 30);
    }

    public void setMonthlyRental(int monthlyRental) {
        this.monthlyRental = monthlyRental ;
    }
}

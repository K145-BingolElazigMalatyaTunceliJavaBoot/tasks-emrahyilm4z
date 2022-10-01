package SecondWeek.CarsType;

public class Suv extends Cars {
    @Override
    public int getMonthlyRental() {
        return super.getMonthlyRental() + (100 / getAge() * 30);
    }
}

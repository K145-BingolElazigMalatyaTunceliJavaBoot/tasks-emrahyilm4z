package SecondWeek.CarsType;

public class Hatchback extends Cars {
    @Override
    public int getMonthlyRental() {
        System.err.println("Hatchback tipi araç aylık kiralama yapılmaz");
        return -1;
    }
}

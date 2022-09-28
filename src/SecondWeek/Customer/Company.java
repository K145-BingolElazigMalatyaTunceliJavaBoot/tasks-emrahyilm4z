package SecondWeek.Customer;

import SecondWeek.CarsType.Hatchback;
import SecondWeek.CarsType.Sedan;
import SecondWeek.CarsType.Suv;


public class Company {
    public Hatchback getHatchbackCar() {
        return new Hatchback();
    }

    public Sedan getSedanCar() {
        return new Sedan();
    }

    public Suv getSuvCar() {
        return new Suv();
    }
}

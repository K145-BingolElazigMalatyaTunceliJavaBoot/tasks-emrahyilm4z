package SecondWeek;

import SecondWeek.CarsType.Sedan;
import SecondWeek.CarsType.Suv;
import SecondWeek.Customer.Company;

public class MainCars {
    public static void main(String[] args) {
        Company company = new Company();
        Suv suv = company.getSuvCar();
        System.out.println(suv.dailyRental());
        System.out.println(suv.monthlyRental());
    }
}

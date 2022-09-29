package SecondWeek;

import SecondWeek.CarsType.Hatchback;
import SecondWeek.CarsType.Sedan;
import SecondWeek.CarsType.Suv;


public class RentCar {
    public static void main(String[] args) {

        Hatchback hatchback = new Hatchback();
        Suv suv = new Suv();
        Sedan sedan = new Sedan();


        // Hatchback araç ekleme
        hatchback.setAge(1);
        hatchback.setColor("blue");
        hatchback.setDailyRental(300);
        hatchback.setLuggageCapacity(400);

        //Sedan araç ekleme
        sedan.setAge(1);
        sedan.setColor("red");
        sedan.setDailyRental(300);
        sedan.setMonthlyRental(9000);
        sedan.setLuggageCapacity(500);

        //Suv araç ekleme
        suv.setAge(1);
        suv.setColor("yellow");
        suv.setDailyRental(400);
        suv.setLuggageCapacity(600);
        suv.setMonthlyRental(9000);

        Customer citizen = new Customer(false);
        citizen.rentCar(hatchback,suv,sedan);

        Customer company = new Customer(true);
        company.rentCar(hatchback,suv,sedan);

    }
}

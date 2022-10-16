package SecondWeek;

import SecondWeek.CarsType.Hatchback;
import SecondWeek.CarsType.Sedan;
import SecondWeek.CarsType.Suv;
import SecondWeek.Customer.Citizen;
import SecondWeek.Customer.Company;
import SecondWeek.Customer.Customer;
import SecondWeek.Service.RentACarService;


public class Main {
    public static void main(String[] args) {
        RentACarService rentACarService = new RentACarService();
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

        Customer citizen = new Citizen();
        citizen.setIsim("Jhon");
        rentACarService.rentACar(citizen);

        Customer company = new Company();
        company.setIsim("Trendyol");
        rentACarService.rentACar(company);
    }
}

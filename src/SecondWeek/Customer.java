package SecondWeek;

import SecondWeek.CarsType.Hatchback;
import SecondWeek.CarsType.Sedan;
import SecondWeek.CarsType.Suv;

public class Customer {

    private boolean customer;

    public Customer(boolean customer) {
        this.customer = customer;
    }

    public void rentCar(Hatchback hatchback, Suv suv, Sedan sedan) {
        if (customer) {
            System.out.println("Bütün araçları kiralayabilirisiniz");
        } else {
            System.out.println("Sadece hatchback araçlar kiralanabilir");
        }
    }
}

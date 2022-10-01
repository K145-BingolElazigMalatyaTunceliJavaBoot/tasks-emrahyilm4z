package SecondWeek.Service;

import SecondWeek.Customer.Citizen;
import SecondWeek.Customer.Customer;

public class RentACarService {
    public void rentACar(Customer customer){
        if(customer instanceof Citizen){
            System.out.println("Mevcut olan Hatchback arabaları kiralayabilirsiniz");
        }else {
            System.out.println("Mevcut olan arabaları kiralayabilirsiniz.");
        }
    }
}

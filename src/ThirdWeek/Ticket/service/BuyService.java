package ThirdWeek.Ticket.service;

import ThirdWeek.Ticket.entities.Company;
import ThirdWeek.Ticket.entities.Person;


import java.util.List;

public class BuyService {
    public void emptySeats(Company company) {
        System.out.println(company.getSeats());
    }


    public void buySeats(Person person, Company company, List<String> seats, boolean abroad) {
        List<String> companySeats = company.getSeats();
        for (String element : seats) {
            if (!companySeats.contains(element)) {
                System.err.println("Seçtiğiniz koltuk bu uçakta yok. Olan koltuklar satın alındı.");
            } else {
                List<String> strings = person.getSeats();
                companySeats.remove(element);
                strings.add(element + company.getName());
                person.setSeats(strings);
                priceSeat(person, company,element.startsWith("1"), abroad);
            }
        }
        company.setSeats(companySeats);
    }

    private static void priceSeat(Person person, Company company,  boolean business, boolean abroad) {
        int price = business ? company.getBusinessSeat() : company.getEconomicSeat();
        person.setTicketPrice(person.getTicketPrice() + (abroad ? price*2 : price));
    }
}

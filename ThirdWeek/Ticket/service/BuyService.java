package ThirdWeek.Ticket.service;

import ThirdWeek.Ticket.entities.Company;
import ThirdWeek.Ticket.entities.Person;


import java.util.List;
import java.util.Map;

public class BuyService {
    public void emptySeats(Company company) {
        System.out.println(company.getSeats());
    }


    public void buySeats(Person person, Company company, List<String> seats, boolean abroad) {
        Map<String, Integer> companySeats = company.getSeats();
        for (String element : seats) {
            if (!companySeats.containsKey(element)) {
                System.err.println("Seçtiğiniz koltuk bu uçakta yok. Olan koltuklar satın alındı.");
            } else {
                Map<String, Integer> strings = person.getSeats();
                int abroadPrice = abroad ? companySeats.get(element) * 2 : companySeats.get(element);
                strings.put(element + company.getName(), abroadPrice);
                companySeats.remove(element);
                person.setSeats(strings);
                priceSeat(person, abroad);
            }
        }
        company.setSeats(companySeats);
    }

    private static void priceSeat(Person person, boolean abroad) {
        int sum = person.getSeats().values().stream().reduce(0, Integer::sum);
        person.setTicketPrice(sum);
    }
}

package ThirdWeek.Ticket.service;

import ThirdWeek.Ticket.entities.Company;

import java.util.List;

public class BuyService {
    public void emptySeats(Company company) {
        System.out.println(company.getSeats());
    }

    public void buySeats(Company company, List seats) {
        seatControl(company, seats);
    }

    private static void seatControl(Company company, List seats) {
        List companySeats = company.getSeats();
        for (Object element : seats) {
            if (companySeats.contains(element)) {
                companySeats.remove(element);
            } else {
                System.err.println("Seçtiğiniz koltuk bu uçakta yok. Olan koltuklar satın alındı.");
            }
        }
        company.setSeats(companySeats) ;
    }
}

package ThirdWeek.Ticket.Service;

import ThirdWeek.Ticket.Entities.FlyCompany;

import java.util.List;

public class FlyService {
    public void emptySeats(FlyCompany flyCompany) {
        System.out.println(flyCompany.getSeats());
    }

    public void buySeats(FlyCompany flyCompany, List seats) {
        seatControl(flyCompany, seats);
    }

    private static void seatControl(FlyCompany flyCompany, List seats) {
        List companySeats = flyCompany.getSeats();
        for (Object element : seats) {
            if (companySeats.contains(element)) {
                companySeats.remove(element);
            } else {
                System.err.println("Seçtiğiniz koltuk bu uçakta yok. Olan koltuklar satın alındı.");
            }
        }
        flyCompany.setSeats(companySeats);
    }
}

package ThirdWeek.Ticket;

import ThirdWeek.Ticket.entities.Pegasus;
import ThirdWeek.Ticket.entities.Thy;
import ThirdWeek.Ticket.service.BuyService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BuyService service = new BuyService();


        Pegasus pegasus = new Pegasus(6);

        List pegasusSeats = new ArrayList();
        pegasusSeats.add("A1");
        pegasusSeats.add("A2");
        pegasusSeats.add("A2");
        service.buySeats(pegasus,pegasusSeats);

        Thy thy = new Thy(10);
        List thySeats = new ArrayList();
        thySeats.add("C2");
        thySeats.add("B1");
        service.buySeats(thy,thySeats);



        service.emptySeats(pegasus);
        service.emptySeats(thy);
    }
}

package ThirdWeek.Ticket.Entities;

import java.util.ArrayList;
import java.util.List;

public class Pegasus extends FlyCompany {

    public Pegasus(int seatLength) {
        this.setName("Pegasus");
        this.setSeatLengt(seatLength);
        this.setSeats(makeSeat());
        this.setBusinessSeat(2000);
        this.setEconomicSeat(1000);
        this.setAbroadFood(false);
    }

    private List makeSeat() {
        List seats = new ArrayList();
        for (int i = 1; i <= getSeatLengt(); i++) {
            seats.add("A" + i);
            seats.add("B" + i);
            seats.add("C" + i);
            seats.add("D" + i);
            seats.add("E" + i);
            seats.add("F" + i);
        }
        return seats;
    }
}

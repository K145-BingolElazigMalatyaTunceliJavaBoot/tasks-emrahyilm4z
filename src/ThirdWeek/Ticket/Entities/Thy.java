package ThirdWeek.Ticket.Entities;

import java.util.ArrayList;
import java.util.List;

public class Thy extends FlyCompany {
    public Thy(int seatLength) {
        this.setName("Türk Hava Yolları");
        this.setSeatLengt(seatLength);
        this.setSeats(makeSeat());
        this.setBusinessSeat(2300);
        this.setEconomicSeat(1200);
        this.setAbroadFood(true);
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

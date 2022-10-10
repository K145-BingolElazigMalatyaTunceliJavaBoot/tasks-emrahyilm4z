package ThirdWeek.Ticket.entities;

import ThirdWeek.Ticket.core.food.Food;
import ThirdWeek.Ticket.service.SeatService;

public class Pegasus extends Company implements Food {

    public Pegasus(int seatLength) {
        this.setName("Pegasus");
        this.setSeatLengt(seatLength);
        this.setSeats(SeatService.seatService(getSeatLengt()));
        this.setBusinessSeat(2000);
        this.setEconomicSeat(1000);
    }

    @Override
    public void abroadFood() {
        System.out.println("Yurt dışı uçuşlarımızda yemek servisimiz yoktur.");
    }

    @Override
    public void domesticFood() {
        System.out.println("Yurtiçi uçuşlarımızda yemek servisimiz vardır.");
    }
}

package ThirdWeek.Ticket.entities;

import ThirdWeek.Ticket.core.food.Food;
import ThirdWeek.Ticket.service.SeatService;

public class SunExpress extends Company implements Food {
    public SunExpress(int seatLength) {
        this.setName("Sun Express");
        this.setSeatLengt(seatLength);
        this.setSeats(SeatService.seatService(getSeatLengt()));
        this.setBusinessSeat(2150);
        this.setEconomicSeat(1100);
    }

    @Override
    public void abroadFood() {
        System.out.println("Yurt dışı uçuşlarımızda yemek servisimiz vardır.");
    }

    @Override
    public void domesticFood() {
        System.out.println("Yurtiçi uçuşlarımızda yemek servisimiz yoktur.");
    }
}

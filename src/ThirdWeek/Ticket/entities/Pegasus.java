package ThirdWeek.Ticket.entities;

import ThirdWeek.Ticket.core.food.Food;
import ThirdWeek.Ticket.service.SeatService;

public class Pegasus extends Company implements Food {

    public Pegasus(int seatLength) {
        this.setName("Pegasus");
        this.setSeatLengt(seatLength);
        this.setBusiness(2000);
        this.setEconomic(1000);
        this.setSeats(SeatService.seatService(getSeatLengt(), this.getBusiness(), this.getEconomic()));
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

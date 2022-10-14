package ThirdWeek.Ticket.entities;

import ThirdWeek.Ticket.core.food.Food;
import ThirdWeek.Ticket.service.SeatService;

public class Thy extends Company implements Food {
    public Thy(int seatLength) {
        this.setName("Türk Hava Yolları");
        this.setSeatLengt(seatLength);
        this.setBusiness(2300);
        this.setEconomic(1200);
        this.setSeats(SeatService.seatService(getSeatLengt(), this.getBusiness(),this.getEconomic()));
    }

    @Override
    public void abroadFood() {
        System.out.println("Yurt dışı uçuşlarımızda yemek servisimiz vardır.");
    }

    @Override
    public void domesticFood() {
        System.out.println("Yurtiçi uçuşlarımızda yemek servisimiz vardır.");
    }
}

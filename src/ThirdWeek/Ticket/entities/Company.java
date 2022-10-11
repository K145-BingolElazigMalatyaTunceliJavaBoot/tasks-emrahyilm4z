package ThirdWeek.Ticket.entities;

import java.util.List;

public class Company {
    private String name;
    private List<String> seats;
    private int seatLengt;
    private int businessSeat;
    private int economicSeat;




    public int getBusinessSeat() {
        return businessSeat;
    }

    public void setBusinessSeat(int businessSeat) {
        this.businessSeat = businessSeat;
    }

    public int getEconomicSeat() {
        return economicSeat;
    }

    public void setEconomicSeat(int economicSeat) {
        this.economicSeat = economicSeat;
    }

    public int getSeatLengt() {
        return seatLengt;
    }

    public void setSeatLengt(int seatLengt) {
        this.seatLengt = seatLengt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSeats() {
        return seats;
    }

    public void setSeats(List<String> seats) {
        this.seats = seats;
    }


}

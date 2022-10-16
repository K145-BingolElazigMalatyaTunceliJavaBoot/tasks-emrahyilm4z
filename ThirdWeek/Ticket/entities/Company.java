package ThirdWeek.Ticket.entities;

import java.util.List;
import java.util.Map;

public class Company {
    private String name;
    private Map<String, Integer> seats;
    private int seatLengt;

    private int business;

    private int economic;

    public int getBusiness() {
        return business;
    }

    public void setBusiness(int business) {
        this.business = business;
    }

    public int getEconomic() {
        return economic;
    }

    public void setEconomic(int economic) {
        this.economic = economic;
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

    public Map<String, Integer> getSeats() {
        return seats;
    }

    public void setSeats(Map<String, Integer> seats) {
        this.seats = seats;
    }
}

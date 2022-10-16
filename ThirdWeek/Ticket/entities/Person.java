package ThirdWeek.Ticket.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Person {
    private String nameSurname;
    private Map<String ,Integer> seats = new HashMap<String,Integer>();
    private int ticketPrice;

    public Person(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public Map<String, Integer> getSeats() {
        return seats;
    }

    public void setSeats(Map<String, Integer> seats) {
        this.seats = seats;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }


    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public String toString() {
        return "Person{" +
                "nameSurname='" + nameSurname + '\'' +
                ", seats=" + seats +
                ", ticketPrice=" + ticketPrice +
                '}';
    }
}

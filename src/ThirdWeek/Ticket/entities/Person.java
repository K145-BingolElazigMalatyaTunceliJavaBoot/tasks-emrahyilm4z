package ThirdWeek.Ticket.entities;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String nameSurname;
    private List<String> seats = new ArrayList<String>();
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

    public List<String> getSeats() {
        return seats;
    }

    public void setSeats(List<String> seats) {
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

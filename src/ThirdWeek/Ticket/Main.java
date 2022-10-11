package ThirdWeek.Ticket;

import ThirdWeek.Ticket.entities.Pegasus;
import ThirdWeek.Ticket.entities.Person;
import ThirdWeek.Ticket.entities.SunExpress;
import ThirdWeek.Ticket.entities.Thy;
import ThirdWeek.Ticket.service.BuyService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BuyService service = new BuyService();

        Pegasus pegasus = new Pegasus(6);
        Thy thy = new Thy(10);
        SunExpress sunExpress = new SunExpress(20);


        List<String> pegasusSeat = new ArrayList<String>();
        List<String> thySeat = new ArrayList<String>();
        List<String> sunExpressSeat = new ArrayList<>();

        Person person = new Person("Emrah Yılmaz");

        pegasusSeat.add("A1");
        pegasusSeat.add("A2");

        thySeat.add("1A");
        thySeat.add("1B");

        sunExpressSeat.add("C2");
        sunExpressSeat.add("F6");

        service.buySeats(person, pegasus, pegasusSeat, false);
        service.buySeats(person, thy, thySeat, false);
        service.buySeats(person,sunExpress,sunExpressSeat,false);

        System.out.println(person.toString());
    }
}

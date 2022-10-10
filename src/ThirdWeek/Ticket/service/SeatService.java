package ThirdWeek.Ticket.service;

import java.util.ArrayList;
import java.util.List;

public class SeatService {

    public static List<String> seatService(int seatLength) {
        List<String> seats = new ArrayList<String>();
        final String[] seatLetter = {"A", "B", "C", "D", "E", "F"};
        for (int i = 0; i < seatLetter.length; i++) {
            seats.add("1" + seatLetter[i]);
        }
        for (int i = 1; i <= seatLength; i++) {
            for (int j = 0; j < seatLetter.length; j++) {
                seats.add(seatLetter[j] + "" + i);
            }
        }
        return seats;
    }
}

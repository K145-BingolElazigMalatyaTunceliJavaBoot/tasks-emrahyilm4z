package ThirdWeek.Ticket.service;

import ThirdWeek.Ticket.entities.Company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SeatService {

    public static Map<String, Integer> seatService(int seatLength, int business, int economic) {
        Map<String, Integer> seats = new HashMap<String, Integer>();
        final String[] seatLetter = {"A", "B", "C", "D", "E", "F"};
        for (int i = 0; i < seatLetter.length; i++) {
            seats.put( 1+ seatLetter[i] , business);
        }
        for (int i = 1; i <= seatLength; i++) {
            for (int j = 0; j < seatLetter.length; j++) {
                seats.put(seatLetter[j] + i, economic);
            }
        }
        return seats;
    }
}

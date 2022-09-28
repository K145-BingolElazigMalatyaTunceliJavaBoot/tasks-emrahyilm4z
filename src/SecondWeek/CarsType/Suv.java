package SecondWeek.CarsType;

import SecondWeek.Cars;

public class Suv implements Cars {

    public String carColor() {
        return "red";
    }

    //Yaşına bağlı olarak değişkenlik gösteren günlük kiralama
    public int dailyRental() {
        int age = 2;
        return 350 + (100 / age);
    }

    public int luggageCapacity() {
        return 500;
    }

    //Aracın Yaşına bağlı olarak değişkenlik gösteren aylık kiralama
    public int monthlyRental() {
        return dailyRental() * 30;
    }

}

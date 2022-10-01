package SecondWeek.CarsType;

public abstract class Cars {

    private int luggageCapacity;
    private int dailyRental;
    private String color;
    private int monthlyRental;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public int getMonthlyRental() {
        return monthlyRental;
    }

    public void setMonthlyRental(int monthlyRental) {
        this.monthlyRental = monthlyRental;
    }

    public int getLuggageCapacity() {
        return luggageCapacity;
    }

    public void setLuggageCapacity(int luggageCapacity) {
        this.luggageCapacity = luggageCapacity;
    }

    public int getDailyRental() {
        return dailyRental;
    }

    public void setDailyRental(int dailyRental) {
        this.dailyRental = dailyRental;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

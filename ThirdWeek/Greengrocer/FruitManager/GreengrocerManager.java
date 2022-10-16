package ThirdWeek.Greengrocer.FruitManager;

import ThirdWeek.Greengrocer.Entities.Fruit;

public class GreengrocerManager {
    public void add(Fruit fruit, int kg) {
        fruit.setKg(kg);
    }

    public void buyFruit(Fruit fruit, int kg) throws Exception {
        if (fruit.getKg() < kg) {
            throw new Exception("Malesef elmizde " + kg + " kilogram " + fruit.getFruitName() + " yok");
        } else {
            System.out.println(kg + " kg " + fruit.getFruitName() + " alındı");
        }
    }
}

package ThirdWeek.Greengrocer;

import ThirdWeek.Greengrocer.FruitManager.GreengrocerManager;
import ThirdWeek.Greengrocer.Entities.Apple;
import ThirdWeek.Greengrocer.Entities.Cherry;
import ThirdWeek.Greengrocer.Entities.Pear;

public class Main {
    public static void main(String[] args) throws Exception {
        GreengrocerManager greengrocerManager = new GreengrocerManager();

        Apple apple = new Apple();
        Pear pear = new Pear();
        Cherry cherry = new Cherry();

        greengrocerManager.add(apple,50);
        greengrocerManager.add(cherry,30);
        greengrocerManager.add(pear,10);

        greengrocerManager.buyFruit(apple,20);
        greengrocerManager.buyFruit(cherry,15);
        greengrocerManager.buyFruit(pear,30);

    }
}

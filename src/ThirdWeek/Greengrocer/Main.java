package ThirdWeek.Greengrocer;

import ThirdWeek.Greengrocer.FruitManager.AddFruitManager;
import ThirdWeek.Greengrocer.FruitManager.BuyFruitManager;
import ThirdWeek.Greengrocer.Entities.Apple;
import ThirdWeek.Greengrocer.Entities.Cherry;
import ThirdWeek.Greengrocer.Entities.Pear;

public class Main {
    public static void main(String[] args) throws Exception {
        BuyFruitManager buyFruitManager = new BuyFruitManager();
        AddFruitManager addFruitManager = new AddFruitManager();

        Apple apple = new Apple();
        Pear pear = new Pear();
        Cherry cherry = new Cherry();

        addFruitManager.add(apple,50);
        addFruitManager.add(cherry,30);
        addFruitManager.add(pear,10);

        buyFruitManager.buyFruit(apple,20);
        buyFruitManager.buyFruit(cherry,15);
        buyFruitManager.buyFruit(pear,30);

    }
}

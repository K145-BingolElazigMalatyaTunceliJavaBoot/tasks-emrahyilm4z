package ThirdWeek.Greengrocer;

import ThirdWeek.Greengrocer.Fruits.Apple;
import ThirdWeek.Greengrocer.Fruits.Cherry;
import ThirdWeek.Greengrocer.Fruits.Pear;

public class Main {
    public static void main(String[] args) throws Exception {
        Apple apple = new Apple(10);
        Pear pear = new Pear(50);
        Cherry cherry = new Cherry(20);

        FruitManager fruitManager = new FruitManager();
        fruitManager.buyFruit(pear,30);
        fruitManager.buyFruit(cherry,15);
        fruitManager.buyFruit(apple,20);
    }
}

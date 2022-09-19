package BirinciHafta;

import java.util.Random;

/**
 * 0 ile 500 aralığında ve
 * Bu sayılardan 50 ile 100 arasında bir sayı bulunana kadar rastgele sayılar seçilir.
 * 50 ile 100 arasındaki sayının kaçıncı seçimde bulunduğunu bulan program.
 */

public class SayiTahmini {
    public static void main(String[] args) {
        Random random = new Random();
        boolean sayiBul = true;
        int sayac = 0;
        while (sayiBul) {
            int randomSayi = random.nextInt(500);
            sayac++;
            if (randomSayi >= 50 && randomSayi < 100) {
                sayiBul = false;
            }
        }
        System.out.println(sayac);
    }
}
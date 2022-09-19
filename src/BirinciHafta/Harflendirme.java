package BirinciHafta;

import java.util.Random;

/**
 * Okul puanlarının harf karşılığını yazan program.
 * Random alınabilir değerler.
 * 0 - 35 arası FF
 * 35 - 50 arası DC
 * 50 - 70 arası BB
 * 70 - 100 arası AA
 */

public class Harflendirme {

    static void harflendirme(int randomSayi) {
        if (randomSayi >= 0 && randomSayi < 35) {
            System.out.println("FF");
        } else if (randomSayi >= 35 && randomSayi < 50) {
            System.out.println("DC");
        } else if (randomSayi >= 50 && randomSayi < 70) {
            System.out.println("BB");
        } else {
            System.out.println("AA");
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int randomSayi = random.nextInt(100);
        System.out.println(randomSayi);
        harflendirme(randomSayi);
    }
}

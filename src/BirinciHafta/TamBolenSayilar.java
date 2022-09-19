package BirinciHafta;

/**
 * 200 ile 500 arasındaki 3 ile tam bölünen sayılar dışındaki sayıların toplamını bulan program.
 *
 */

public class TamBolenSayilar {
    public static void main(String[] args) {
        int toplamSayi = 0 ;
        for (int i = 200; i < 500; i++) {
            if(i % 3 != 0){
                toplamSayi += i;
            }
        }
        System.out.println(toplamSayi);
    }
}
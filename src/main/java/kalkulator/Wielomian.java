package kalkulator;

import java.util.Arrays;

public class Wielomian {

    public static int obliczWielomian(int x) {
        return (int) (Math.pow(x, 5) + 4*(Math.pow(x, 4)) + 3*(Math.pow(x, 3)) -2*(Math.pow(x, 2)) + 17)
                / (int) (Math.pow(x, 2) -7*x + 1);
    }

    public static void main(String []args) {
        int[] tablica = new int[6];
        int[] x = {-3, -2, -1, 1, 2, 3};
        for (int i = 0; i < x.length; i++) {

            tablica[i] = obliczWielomian(x[i]);
        }
        System.out.println(Arrays.toString(tablica));
    }
}

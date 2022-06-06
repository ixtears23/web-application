package junseok.snr.web.util;

import java.util.SplittableRandom;

public class RandomNumber {
    private static final int ZERO = 0;
    private static final int TEN = 10;

    public static String getNumber(final int size) {
        StringBuilder number = new StringBuilder();
        SplittableRandom splittableRandom = new SplittableRandom();
        final int[] ints = splittableRandom.ints(size, ZERO, TEN).toArray();

        for (int anInt : ints) {
            number.append(anInt);
        }
        return number.toString();
    }

    private RandomNumber() {}
}

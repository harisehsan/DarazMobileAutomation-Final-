package homepage.desktop.helper;

import java.util.Random;

public class RandomHelper {
    public static int randomNumberInRange (int max, int min) {
        Random random = new Random();
        return random.nextInt(max - min +1) + min;
    }
}

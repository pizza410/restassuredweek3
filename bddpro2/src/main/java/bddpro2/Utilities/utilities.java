package bddpro2.Utilities;

import java.util.Random;

public class utilities {
    public static String getRandomValue(){
        Random random = new Random();
        int randomInt = random.nextInt(100000);
        return Integer.toString(randomInt);
    }
}

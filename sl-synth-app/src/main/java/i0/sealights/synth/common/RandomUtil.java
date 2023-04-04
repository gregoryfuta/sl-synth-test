package i0.sealights.synth.common;

import java.util.Random;

public class RandomUtil {
    
    private static final Random rnd = new Random();
    
    public static long randomLongMax(int maxValue) {
        return rnd.nextInt(maxValue);
    }
}

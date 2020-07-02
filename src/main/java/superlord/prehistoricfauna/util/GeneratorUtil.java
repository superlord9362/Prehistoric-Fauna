package superlord.prehistoricfauna.util;

import java.util.Random;

public class GeneratorUtil {

	public static int nextIntBetween(Random rand, int a, int b)
    {
        if (a == b) {return a;}
        int min = a < b ? a : b;
        int max = a > b ? a : b;
        return min + rand.nextInt(1 + max - min);
    }
	
}

package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGenerator {
    private static final Random random = new Random();

    public static int makeRanNum() {
        return random.nextInt(10);
    }
}

package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGenerator {
    private static final Random random = new Random();

    private static int makeRanNum() {
        return random.nextInt(10);
    }

    public static List<Integer> makeRanNumList(int carSize) {
        List<Integer> randomNumList = new ArrayList<>();

        for (int i=0; i<carSize; i++) {
            randomNumList.add(makeRanNum());
        }

        return randomNumList;
    }
}

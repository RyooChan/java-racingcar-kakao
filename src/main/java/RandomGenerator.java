import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.shuffle;
import static java.util.List.*;

public class RandomGenerator {
    public final static int[] RANDOM_NUM_LIST = new int[10];
    private final static List<Integer> NUM_LIST = of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

    private static int makeRanNum() {
        List<Integer> copy = new ArrayList<>(NUM_LIST);
        shuffle(copy);

        for (int i=0; i<10; i++) {
            RANDOM_NUM_LIST[i] = copy.get(i);
        }

        return RANDOM_NUM_LIST[0];
    }

    public static List<Integer> makeRanNumList(String[] strList) {
        List<Integer> randomNumList = new ArrayList<>();

        for (int i=0; i<strList.length; i++) {
            randomNumList.add(makeRanNum());
        }

        return randomNumList;
    }
}

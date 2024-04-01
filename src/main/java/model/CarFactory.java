package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class CarFactory {
    public static final int START_SCORE = 1;

    public static List<Car> createCarFromNameList(List<String> carNameList) {
        validateCarNameDuplicate(carNameList);

        return carNameList.stream()
            .map(carName -> {
                return new Car(carName, START_SCORE);
            })
            .collect(toList());
    }

    public static void validateCarNameDuplicate(List<String> carNameList) {
        Set<String> carNameSet = new HashSet<>(carNameList);

        if (carNameSet.size() != carNameList.size()) {
            throw new IllegalArgumentException("동일 이름은 사용 불가능합니다.");
        }
    }
}

package model;

public interface CarMove {
    default int move() {
        return RandomGenerator.makeRanNum();
    }
}

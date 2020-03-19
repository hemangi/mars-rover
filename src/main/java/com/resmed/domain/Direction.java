package com.resmed.domain;

import java.util.HashMap;
import java.util.Map;

public enum Direction {
    N(0),
    E(1),
    S(2),
    W(3);

    private int index;
    private static Map<Integer, Direction> map = new HashMap<>();

    static {
        for (Direction direction : Direction.values()) {
            map.put(direction.index, direction);
        }
    }

    Direction(int direction) {
        this.index = direction;
    }

    public static Direction valueOf(int directionNum) {
        return map.get(directionNum);
    }

    public Direction left() {
        return rotate(-1);
    }

    public Direction right() {
        return rotate(1);
    }

    private Direction rotate(int step) {
        return Direction.valueOf((this.index + step) < 0 ? map.size() - 1 : (this.index + step) % map.size());
    }
}

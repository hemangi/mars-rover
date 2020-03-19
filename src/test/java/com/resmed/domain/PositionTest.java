package com.resmed.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class PositionTest {
    @Test
    public void shouldReturnCorrectDirectionAndPositionCoOrdinates() {
        Position position = new Position(1, 1, Direction.N);

        Position newPosition = position.getNextPosition();
        assertEquals(newPosition.getX(), 1);
        assertEquals(newPosition.getY(), 2);
        assertEquals(newPosition.getDirection(), Direction.N);

        newPosition.setDirection(Direction.W);
        newPosition = newPosition.getNextPosition();
        assertEquals(newPosition.getX(), 0);
        assertEquals(newPosition.getY(), 2);
        assertEquals(newPosition.getDirection(), Direction.W);


        newPosition.setDirection(Direction.E);
        newPosition = newPosition.getNextPosition();
        assertEquals(newPosition.getX(), 1);
        assertEquals(newPosition.getY(), 2);
        assertEquals(newPosition.getDirection(), Direction.E);

        newPosition.setDirection(Direction.S);
        newPosition = newPosition.getNextPosition();
        assertEquals(newPosition.getX(), 1);
        assertEquals(newPosition.getY(), 1);
        assertEquals(newPosition.getDirection(), Direction.S);
    }
}

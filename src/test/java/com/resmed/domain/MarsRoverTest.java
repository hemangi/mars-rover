package com.resmed.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MarsRoverTest {
    @Test
    public void shouldReturnCorrectMovementOfRover() {

        MarsRover rover = new MarsRover();
        Position position = new Position(0, 0, Direction.E);

        rover.move(position);

        Position nextPosition = rover.getPosition().getNextPosition();
        rover.move(nextPosition);

        assertEquals(1, rover.getPosition().getX());
        assertEquals(0, rover.getPosition().getY());
        assertEquals(Direction.E, rover.getPosition().getDirection());



        rover.rotateLeft();
        assertEquals(Direction.N, rover.getPosition().getDirection());

        nextPosition = rover.getPosition().getNextPosition();
        rover.move(nextPosition);

        rover.rotateRight();
        assertEquals(1, rover.getPosition().getX());
        assertEquals(1, rover.getPosition().getY());
        assertEquals(Direction.E, rover.getPosition().getDirection());


        rover.rotateRight();
        assertEquals(Direction.S, rover.getPosition().getDirection());

        rover.rotateRight();
        assertEquals(Direction.W, rover.getPosition().getDirection());
    }

    @Test
    void shouldThrowExceptionIfMoveToPositionIsNull() {
        MarsRover rover = new MarsRover();
        assertThrows(IllegalArgumentException.class, () -> rover.move(null));
    }
}

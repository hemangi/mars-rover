package com.resmed.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlateauTest {

    @Test
    public void shouldReturnTrueForValidPosition() {
        Position position = new Position(2, 3, Direction.N);

        Plateau plateau = new Plateau(4, 4);
        assertTrue(plateau.isValidPosition(position));
    }


    @Test
    public void shouldReturnFalseForInValidPosition() {
        Position position = new Position(9, 5, Direction.N);

        Plateau plateau = new Plateau(4, 4);
        assertFalse(plateau.isValidPosition(position));
    }
}

package com.resmed.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DirectionTest {

    @Test
    public void shouldReturnCorrectDirectionAfterRotation() {
        Direction classToTest = Direction.N;

        classToTest = classToTest.right();
        assertEquals(classToTest, Direction.E);

        classToTest = classToTest.right();
        assertEquals(classToTest, Direction.S);

        classToTest = classToTest.right();
        assertEquals(classToTest, Direction.W);

        classToTest = classToTest.right();
        assertEquals(classToTest, Direction.N);

        classToTest = classToTest.right();
        assertEquals(classToTest, Direction.E);

        classToTest = classToTest.left();
        assertEquals(classToTest, Direction.N);

        classToTest = classToTest.left();
        assertEquals(classToTest, Direction.W);

        classToTest = classToTest.left();
        assertEquals(classToTest, Direction.S);

        classToTest = classToTest.left();
        assertEquals(classToTest, Direction.E);

        classToTest = classToTest.left();
        assertEquals(classToTest, Direction.N);
    }
}

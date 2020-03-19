package com.resmed.service;

import static com.resmed.domain.Command.*;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

import com.resmed.domain.*;
import org.junit.jupiter.api.Test;


public class GameServiceTest {

    private static final Position IN_VALID_POSITION = new Position(-1, 1, Direction.N);
    private static final Position VALID_POSITION = new Position(0, 1, Direction.N);
    private static final Plateau PLATEAU = new Plateau(4, 4);
    private static final MarsRover ROVER = new MarsRover();
    private static final GameService GAME_SERVICE = new GameService(PLATEAU, ROVER);


    @Test
    public void shouldPlaceRoverOnBoardAtCorrectPosition() {
        GAME_SERVICE.place(VALID_POSITION);

        assertEquals(VALID_POSITION, GAME_SERVICE.rover.getPosition());
    }

    @Test
    public void shouldThrowExceptionIfInCorrectPosition() {
        assertThrows(IllegalArgumentException.class, () -> GAME_SERVICE.place(IN_VALID_POSITION));
    }

    @Test
    public void shouldEvalCorrectForPlaceCommand() {
        GAME_SERVICE.place(VALID_POSITION);

        assertEquals("0, 1, N", GAME_SERVICE.report());
    }

    @Test
    public void shouldReturnExceptionMessageForPlaceCommand() {
        Position initialValidPosition = new Position(-1, 0, Direction.N);
        assertThrows(IllegalArgumentException.class, () -> GAME_SERVICE.place(initialValidPosition));
    }

    @Test
    public void shouldEvalCorrectForMoveCommand() {
        Position position = new Position(0, 1, Direction.N);
        GAME_SERVICE.place(position);

        GAME_SERVICE.eval(asList(M));

        assertEquals("0, 2, N", GAME_SERVICE.report());
    }

    @Test
    public void shouldReturnExceptionMessageForMoveCommand() {
        GAME_SERVICE.place(new Position(0, 0, Direction.S));

        assertEquals("ERR!! At the edge of plateau", GAME_SERVICE.eval(asList(M)));
        assertEquals("0, 0, S", GAME_SERVICE.report());
    }

    @Test
    public void shouldEvalCorrectForLeftCommand() {
        GAME_SERVICE.eval((asList(L)));
        assertEquals("1, 0, E", GAME_SERVICE.report());
    }

    @Test
    public void shouldEvalCorrectForRightCommand() {
        GAME_SERVICE.eval(asList(R));
        assertEquals("0, 1, E", GAME_SERVICE.report());
    }

    @Test
    public void shouldEvalCorrectForMultipleCommand() {
        GAME_SERVICE.eval((asList(L, M, R)));
        assertEquals("1, 0, S", GAME_SERVICE.report());
    }
}

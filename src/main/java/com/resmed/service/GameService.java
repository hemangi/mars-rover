package com.resmed.service;

import com.resmed.domain.*;
import javafx.util.Pair;

import java.util.List;

public class GameService {

    Plateau plateau;
    MarsRover rover;

    public GameService(Plateau plateau, MarsRover rover) {
        this.plateau = plateau;
        this.rover = rover;
    }

    public void place(Position position) {
        if (position == null)
            throw new IllegalArgumentException("Provide correct position");

        if (plateau.isValidPosition(position)) {
            rover.move(position);
        } else {
            throw new IllegalArgumentException("Provide correct position");
        }
    }

    public String eval(List<Command> commands) throws IllegalArgumentException {
        String output = "";
        for (Command c: commands) {
            switch (c) {
                case M:
                    Position newPosition = rover.getPosition().getNextPosition();
                    if (plateau.isValidPosition(newPosition)) {
                        rover.move(newPosition);
                    } else {
                        output =  "ERR!! At the edge of plateau";
                    }
                    break;
                case L:
                    rover.rotateLeft();
                    break;
                case R:
                    rover.rotateRight();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid command");
            }
        }
        return output;
    }

    public String report() {
        if (rover.getPosition() == null)
            return null;

        return rover.getPosition().getX() + ", " + rover.getPosition().getY() + ", " + rover.getPosition().getDirection().toString();
    }
}

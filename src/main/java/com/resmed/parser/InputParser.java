package com.resmed.parser;

import com.resmed.domain.Command;
import com.resmed.domain.Direction;
import com.resmed.domain.Position;
import javafx.util.Pair;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class InputParser {

    public Pair<Integer, Integer> parsePlateauCoordinates(String input) throws IllegalArgumentException {
        String[] args = input.split(" ");
        try {
            return new Pair<>(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Provide valid command");
        }
    }

    public List<Command> parse(String input) throws IllegalArgumentException {
        List<Command> commands = new ArrayList<>();
        try {
            for (int i=0; i<= input.length() - 1; i++) {
                commands.add(Command.valueOf(((Character)input.charAt(i)).toString()));
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Provide valid command");
        }
        return commands;
    }

    public Position placeRover(String input) {

        String[] params = input.split(" ");
        validatePlace(params);
        try {
            int x  = Integer.parseInt(params[0]);
            int y = Integer.parseInt(params[1]);
            Direction direction = Direction.valueOf(params[2]);
            return new Position( x, y, direction);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid command");
        }
    }


    private void validatePlace(String[] args) {
        if (args.length < 2) {
            throw new IllegalArgumentException("Provide valid args to PLACE");
        }
    }
}

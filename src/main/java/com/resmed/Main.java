package com.resmed;

import com.resmed.domain.*;
import com.resmed.service.GameService;
import javafx.util.Pair;
import com.resmed.parser.InputParser;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class Main implements Runnable {

    private final InputStream inputStream;
    private final PrintStream printStream;
    private final Scanner scanner;

    public Main(InputStream inputStream, PrintStream printStream) {
        this.inputStream = inputStream;
        this.printStream = printStream;
        this.scanner = new Scanner(inputStream);
    }

    public static void main (String args[]) {
        new Main(System.in, System.out).run();
    }

    public void run() {
        printStream.print("Mars Rover\n");
        InputParser parser = new InputParser();
        String coordinates = scanner.nextLine();
        Pair<Integer, Integer> size = parser.parsePlateauCoordinates(coordinates);

        Plateau plateau = new Plateau(size.getKey(), size.getValue());

        GameService rover1 = new GameService(plateau, new MarsRover());
        GameService rover2 = new GameService(plateau, new MarsRover());

        String rover1Position = scanner.nextLine();
        String rover1Commands = scanner.nextLine().toUpperCase();
        String rover2Position = scanner.nextLine();
        String rover2Commands = scanner.nextLine().toUpperCase();

        try {
            rover1.place(parser.placeRover(rover1Position));
            rover2.place(parser.placeRover(rover2Position));
            rover1.eval(parser.parse(rover1Commands));
            rover2.eval(parser.parse(rover2Commands));
            printStream.println(rover1.report());
            printStream.println(rover2.report());
        } catch (IllegalArgumentException e) {
            printStream.println(e.getMessage());
        }
    }
}

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
        InputParser inputParser = new InputParser();
        String coordinates = scanner.nextLine();
        Pair<Integer, Integer> plateauCoordinates = inputParser.parsePlateauCoordinates(coordinates);

        GameService gameService = new GameService(
                new Plateau(plateauCoordinates.getKey(), plateauCoordinates.getValue()),
                new MarsRover());

        String init = scanner.nextLine();
        gameService.place(inputParser.placeRover(init));
        printStream.print("\n");
        try {
            boolean keepRunning = true;
            while (keepRunning) {
                String inputString = scanner.nextLine().toUpperCase();

                if ("EXIT".equals(inputString)) {
                    keepRunning = false;
                } else {
                    try {
                        List<Command> commands = inputParser.parse(inputString);
                        String outputVal = gameService.eval(commands);
                        printStream.println(outputVal);
                        printStream.println(gameService.report());
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                printStream.println();
            }
        } catch (IllegalArgumentException e) {
            printStream.println(e.getMessage());
        }
    }

}

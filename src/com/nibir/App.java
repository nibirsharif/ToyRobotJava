package com.nibir;

import java.util.Scanner;

public class App {

    private static int x = 0;
    private static int y = 0;
    private static Board board;
    private static String place;
    private static String command;
    private static Direction direction;
    private static Instruction instruction;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        place = args[0].toString();
        if (!place.equalsIgnoreCase("place")) exitFunction(0, "Invalid command!");

        String input[] = args[1].split(",");
        x = Integer.parseInt(input[0]);
        y = Integer.parseInt(input[1]);
        direction = Direction.valueOf(input[2].toString().toUpperCase());

        board = new Board(4,4);
        if (! board.isValidPosition(x, y)) exitFunction(0, "Invalid position!");

        while (sc.hasNextLine()){
            command  = sc.nextLine();
            instruction = Instruction.valueOf(command.toUpperCase());

            if (instruction.equals(Instruction.REPORT)) break;

            switch (instruction) {
                case MOVE:
                    break;
                case LEFT:
                    break;
                case RIGHT:
                    break;
                default:
                    break;
            }

        }
        System.out.println(x + "," + y + "," + direction);
    }

    private static void exitFunction(int value, String message) {
        System.out.println(message + "\n\n");
        System.exit(value);
    }
}

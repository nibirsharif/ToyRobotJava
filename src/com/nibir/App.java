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
                    move(direction);
                    break;
                case LEFT:
                    direction = changeDirection(instruction, direction);
                    break;
                case RIGHT:
                    direction = changeDirection(instruction, direction);
                    break;
                default:
                    break;
            }

        }
        System.out.println(x + "," + y + "," + direction);
    }

    public static void move(Direction direction) {
        switch (direction) {
            case NORTH:
                y++;
                break;
            case SOUTH:
                y--;
                break;
            case EAST:
                x++;
                break;
            case WEST:
                x--;
                break;
            default:
                break;
        }
        if (!board.isValidMove(x, y)) { exitFunction(0, "Invalid move!"); }
    }

    public static Direction changeDirection(Instruction instruction, Direction direction) {
        if (instruction.equals(Instruction.LEFT)) {
            switch (direction) {
                case NORTH:
                    direction = Direction.WEST;
                    break;
                case SOUTH:
                    direction = Direction.EAST;
                    break;
                case EAST:
                    direction = Direction.NORTH;
                    break;
                case WEST:
                    direction = Direction.SOUTH;
                    break;
                default:
                    break;
            }
        } else if (instruction.equals(Instruction.RIGHT)) {
            switch (direction) {
                case NORTH:
                    direction = Direction.EAST;
                    break;
                case SOUTH:
                    direction = Direction.WEST;
                    break;
                case EAST:
                    direction = Direction.SOUTH;
                    break;
                case WEST:
                    direction = Direction.NORTH;
                    break;
                default:
                    break;
            }
        }
        return direction;
    }

    private static void exitFunction(int value, String message) {
        System.out.println(message + "\n\n");
        System.exit(value);
    }
}

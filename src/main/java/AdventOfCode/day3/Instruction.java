package AdventOfCode.day3;

import org.omg.SendingContext.RunTime;

import java.util.ArrayList;
import java.util.List;

public class Instruction {

    private final InstructionDirection direction;
    private final int movement;

    private Instruction(InstructionDirection instructionDirection, int movement) {
        this.direction = instructionDirection;
        this.movement = movement;
    }

    public static Instruction parse(String instructionString) {
        instructionString = instructionString.toUpperCase(); // Just in case
        String instructionPrefix = "";
        InstructionDirection instructionDirection = InstructionDirection.NOT_SET;

        if (instructionString.startsWith("R")){
            instructionPrefix = "R";
            instructionDirection = InstructionDirection.RIGHT;
        }else if (instructionString.startsWith("L")) {
            instructionPrefix = "L";
            instructionDirection = InstructionDirection.DOWN;
        }else if (instructionString.startsWith("U")) {
            instructionPrefix = "U";
            instructionDirection = InstructionDirection.UP;
        }else if (instructionString.startsWith("D")) {
            instructionPrefix = "D";
            instructionDirection = InstructionDirection.DOWN;
        }else {
            throw new RuntimeException("Instruction is invalid. It has to start with R, L, U or D");
        }

        String movement = String.join("", instructionString.split(instructionPrefix));
        // will need to wrap it in a try catch block
        int movementNumber = Integer.parseInt(movement);
        return new Instruction(instructionDirection, movementNumber);
    }

    public List<Coordinate> generatePathForInstruction(Coordinate currentCoordinate) {
        List<Coordinate> path = new ArrayList<>();
        for (int i = 1; i <= movement; i++) {
            switch (direction) {
                case RIGHT:
                    path.add(new Coordinate(currentCoordinate.getX() + i, currentCoordinate.getY()));
                    break;
                case LEFT:
                    path.add(new Coordinate(currentCoordinate.getX() - i, currentCoordinate.getY()));
                    break;
                case UP:
                    path.add(new Coordinate(currentCoordinate.getX(), currentCoordinate.getY() + i));
                    break;
                case DOWN:
                    path.add(new Coordinate(currentCoordinate.getX(), currentCoordinate.getY() - i));
                    break;
                case NOT_SET: throw new RuntimeException("Direction has not been set");
            }
        }
        return path;
    }

}

/*public enum Instruction {

    RIGHT(0),
    LEFT(0),
    UP(0),
    DOWN(0);

    private int movement;

    Instruction(int movement) {
        this.movement = movement;
    }

    public int getMovement() {
        return movement;
    }

    public void setMovement(int movement) {
        this.movement = movement;
    }

    public static Instruction parse(String instructionString) {
        if (instructionString.startsWith("R")) {
            String movement = String.join("", instructionString.split("R"));
            int movementNumber = Integer.parseInt(movement);
            Instruction instruction = Instruction.RIGHT;
            instruction.setMovement(movementNumber);
            return instruction;
        }
        return DOWN;
    }


    //MAYBE??

}*/

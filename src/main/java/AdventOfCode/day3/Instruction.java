package AdventOfCode.day3;

public enum Instruction {

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

}

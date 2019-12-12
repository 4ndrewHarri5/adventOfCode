package AdventOfCode.day2.input;

public abstract class Pairs {

    abstract public InputType getType();

    public static Pairs validPair(int noun, int verb) {
        return new InputPairs(noun, verb);
    }

}

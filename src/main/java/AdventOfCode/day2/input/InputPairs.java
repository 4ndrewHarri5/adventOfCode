package AdventOfCode.day2.input;

public class InputPairs extends Pairs{

    private final int noun;
    private final int verb;

    public InputPairs(int noun, int verb) {
        this.noun = noun;
        this.verb = verb;
    }

    public int getNoun() {
        return noun;
    }

    public int getVerb() {
        return verb;
    }

    @Override
    public InputType getType() {
        return InputType.VALID;
    }
}

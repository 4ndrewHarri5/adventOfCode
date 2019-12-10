package AdventOfCode.day2;

import AdventOfCode.day2.rule.Rule;
import AdventOfCode.day2.rule.Rules;

public class Opcode {

    private final int opcode;

    private Opcode(int opcode) {
        this.opcode = opcode;
    }

    public static Opcode set(int opcode) {
        return new Opcode(opcode);
    }

    public int getOpcode() {
        return opcode;
    }

    public Rule applyRule() {
        return Rules.createFromOpcode(this);
    }

}

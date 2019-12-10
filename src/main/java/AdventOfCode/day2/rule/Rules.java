package AdventOfCode.day2.rule;

import AdventOfCode.day2.Opcode;
import AdventOfCode.day2.result.Result;
import AdventOfCode.day2.util.ListChecker;

import java.util.List;

public enum Rules implements Rule {

    ADD((currentIndex, code) ->  {
        try{
            Integer a = code.get(code.get(currentIndex+1));
            Integer b = code.get(code.get(currentIndex+2));
            Integer indexToChange = code.get(currentIndex+3);
            return Result.number(a+b, indexToChange, currentIndex+4);
        }catch (Exception e) {
            return Result.invalid();
        }
    }),

    MULTIPLY((currentIndex, code) -> {
        try{
            Integer a = code.get(code.get(currentIndex+1));
            Integer b = code.get(code.get(currentIndex+2));
            Integer indexToChange = code.get(currentIndex+3);
            return Result.number(a*b, indexToChange, currentIndex+4);
        }catch (Exception e) {
            return Result.invalid();
        }
    }),

    TERMINATE((a, b) -> Result.terminate()),

    INVALID((a, b) -> Result.invalid());

    Rule rule;

    Rules(Rule rule) {
        this.rule = rule;
    }

    @Override
    public Result with(int currentIndex, List<Integer> code) {
        return rule.with(currentIndex, code);
    }

    public static Rules createFromOpcode(Opcode opcode) {
        switch (opcode.getOpcode()) {
            case 1: return Rules.ADD;
            case 2: return Rules.MULTIPLY;
            case 99: return  Rules.TERMINATE;
            default: return Rules.INVALID;
        }
    }
}

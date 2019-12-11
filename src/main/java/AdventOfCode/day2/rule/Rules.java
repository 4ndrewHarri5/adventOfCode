package AdventOfCode.day2.rule;

import AdventOfCode.day2.Opcode;
import AdventOfCode.day2.result.Result;

import java.util.List;

public enum Rules implements Rule {

    ADD((currentIndex, code) ->  {
        try{
            Integer operation = code.get(code.get(currentIndex+1)) + code.get(code.get(currentIndex+2));
            Integer indexToStore = code.get(currentIndex+3);
            Integer newIndex = currentIndex+4;
            code.set(indexToStore, operation);
            return Result.index(newIndex);
        }catch (Exception e) {
            return Result.terminate();
        }
    }),

    MULTIPLY((currentIndex, code) -> {
        try{
            Integer operation = code.get(code.get(currentIndex+1)) * code.get(code.get(currentIndex+2));
            Integer indexToStore = code.get(currentIndex+3);
            Integer newIndex = currentIndex+4;
            code.set(indexToStore, operation);
            return Result.index(newIndex);
        }catch (Exception e) {
            return Result.terminate();
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

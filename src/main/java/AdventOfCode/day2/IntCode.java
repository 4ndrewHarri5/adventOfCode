package AdventOfCode.day2;

import AdventOfCode.Feature;
import AdventOfCode.File;
import AdventOfCode.Runner;
import AdventOfCode.day2.input.InputPairs;
import AdventOfCode.day2.input.NoPair;
import AdventOfCode.day2.input.Pairs;
import AdventOfCode.day2.result.Result;
import AdventOfCode.day2.result.ResultNextIndex;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class IntCode implements Runner {

    private final List<Integer> initialCode;
    private List<Integer> code;
    private int nextOpcodeIndex = 0;

    public IntCode() {
        initialCode = File.DAY2_1.importFile().stream().map(Integer::valueOf).collect(Collectors.toList());
        code = initialCode;
    }

    public IntCode(List<Integer> initial) {
        initialCode = initial;
        code = initial;
    }

    public void computeCode() {
        loopCode: while(nextOpcodeIndex < code.size()) {
            Integer nextOpcode = code.get(nextOpcodeIndex);
            Result result = Opcode.set(nextOpcode).applyRule().with(nextOpcodeIndex, code).result();
            switch (result.getType()) {
                case NEXTINDEX: nextOpcodeIndex = ((ResultNextIndex) result).getNextIndex(); break;
                case INVALID: nextOpcodeIndex++; break;
                case TERMINATE: break loopCode;
            }
        }
    }

    public Pairs getInputParametersForOutputWithAddress(int output, int address) {
        for (int noun = 0; noun <= 99; noun++) {
            for (int verb = 0; verb <= 99; verb++){
                resetCode();
                code.set(1, noun);
                code.set(2, verb);
                computeCode();
                if (code.get(address) == output) {
                    return new InputPairs(noun, verb);
                }
            }
        }
        return new NoPair();
    }

    private void resetCode(){
        code = new ArrayList<>(initialCode);
        nextOpcodeIndex = 0;
    }

    @Override
    public String run() {
        if (Feature.DAY2_1) {
            computeCode();
            return code.get(0).toString();
        }else if (Feature.DAY2_2) {
            Pairs pairs = getInputParametersForOutputWithAddress(19690720, 0);
            switch (pairs.getType()) {
                case VALID:
                    InputPairs inputPairs = (InputPairs) pairs;
                    return (100 * inputPairs.getNoun() + inputPairs.getVerb()) + "";
                case INVALID:
                default:
                    return "Could not find output";
            }
        }
        return "";
    }
}

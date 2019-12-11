package AdventOfCode.day2;

import AdventOfCode.File;
import AdventOfCode.Runner;
import AdventOfCode.day2.result.Result;
import AdventOfCode.day2.result.ResultNextIndex;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class IntCode implements Runner {

    private List<Integer> code;
    private int nextOpcodeIndex = 0;

    public IntCode() {
        reset();
    }

    private void runIntCode() {
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

    private void reset() {
        code = new ArrayList<>();
        code = File.DAY2_1.importFile().stream().map(Integer::valueOf).collect(Collectors.toList());
    }

    @Override
    public String run() {
        runIntCode();
        return code.get(0).toString();
    }
}

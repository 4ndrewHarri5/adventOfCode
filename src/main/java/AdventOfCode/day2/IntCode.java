package AdventOfCode.day2;

import AdventOfCode.File;
import AdventOfCode.Runner;
import AdventOfCode.day2.result.Result;
import AdventOfCode.day2.result.ResultNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntCode implements Runner {

    private List<Integer> code;

    public IntCode() {
        code = new ArrayList<>();
        code = File.DAY2_1
                .importFile()
                .stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());

    }

    private void runIntCode() {
        final int[] nextOpcodeIndex = {0};
        loopCode: while(nextOpcodeIndex[0] < code.size()) {
            Integer nextOpcode = code.get(nextOpcodeIndex[0]);
            Result opcodeResult = Opcode.set(nextOpcode).applyRule().with(nextOpcodeIndex[0], code).result();
            switch (opcodeResult.getType()) {
                case NUMBER: {
                    ResultNumber resultNumber = (ResultNumber) opcodeResult;
                    code.set(resultNumber.getIndexToStore(), resultNumber.getNumber());
                    nextOpcodeIndex[0] = resultNumber.getNewIndex();
                    break;
                }
                case NEXTINDEX:
                    break loopCode;
                case TERMINATE: {
                    System.out.println("lets stop");
                    break loopCode;
                }
                case INVALID: {
                    System.out.println("invalid");
                    break loopCode;
                }
            }
        }
    }

    @Override
    public String run() {
        runIntCode();
        return code.get(0).toString();
    }
}

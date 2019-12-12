package AdventOfCodeTests.day2Tests;

import AdventOfCode.File;
import AdventOfCode.day2.IntCode;
import AdventOfCode.day2.Opcode;
import AdventOfCode.day2.input.InputPairs;
import AdventOfCode.day2.input.Pairs;
import AdventOfCode.day2.result.Result;
import AdventOfCode.day2.result.ResultType;
import AdventOfCode.day2.rule.Rule;
import AdventOfCode.day2.rule.Rules;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OpcodeTests {

    @Test
    public void whenOpcodeIs1RuleIsAdd() {
        //Arrange
        int opcode = 1;
        //Act
        Rule rule = Opcode.set(opcode).applyRule();
        //Assert
        Assertions.assertThat(rule).isEqualTo(Rules.ADD);
    }

    @Test
    public void whenOpcodeIs2RuleIsMultiply() {
        //Arrange
        int opcode = 2;
        //Act
        Rule rule = Opcode.set(opcode).applyRule();
        //Assert
        Assertions.assertThat(rule).isEqualTo(Rules.MULTIPLY);
    }

    @Test
    public void whenOpcodeIs99RuleIsTerminate() {
        //Arrange
        int opcode = 99;
        //Act
        Rule rule = Opcode.set(opcode).applyRule();
        //Assert
        Assertions.assertThat(rule).isEqualTo(Rules.TERMINATE);
    }

    @Test
    public void whenOpcodeIs87RuleIsInvalid() {
        //Arrange
        int opcode = 87;
        //Act
        Rule rule = Opcode.set(opcode).applyRule();
        //Assert
        Assertions.assertThat(rule).isEqualTo(Rules.INVALID);
    }

    @Test
    public void whenOpcodeIs1AndParametersAre2And3And0WithTerminationThenResultIs_3_2_3_0_99() {
        //Arrange
        List<Integer> code = Arrays.asList(1,2,3,0,99);
        int currentOpcode = code.get(0);
        //Act
        Opcode.set(currentOpcode).applyRule().with(0, code);
        //Assert
        Assertions.assertThat(code).isEqualTo(Arrays.asList(3,2,3,0,99));
    }

    @Test
    public void whenOpcodeIs1AndParametersAre5And5And0WithTerminationThenResultIs_4096_5_5_0_99_2048() {
        //Arrange
        List<Integer> code = Arrays.asList(1,5,5,0,99,2048);
        int currentOpcode = code.get(0);
        //Act
        Opcode.set(currentOpcode).applyRule().with(0, code);
        //Assert
        Assertions.assertThat(code).isEqualTo(Arrays.asList(4096,5,5,0,99,2048));
    }

    @Test
    public void whenOpcodeIs2AndParametersAre0And2And0WithTerminationThenResultIs_4_0_2_0_99() {
        //Arrange
        List<Integer> code = Arrays.asList(2,0,2,0,99);
        int currentOpcode = code.get(0);
        //Act
       Opcode.set(currentOpcode).applyRule().with(0, code);
        //Assert
        Assertions.assertThat(code).isEqualTo(Arrays.asList(4,0,2,0,99));
    }

    @Test
    public void whenOpcodeIs2AndParametersAre6And6And0WithTerminationThenResultIs_400_6_6_0_99_0_20() {
        //Arrange
        List<Integer> code = Arrays.asList(2,6,6,0,99,0,20);
        int currentOpcode = code.get(0);
        //Act
        Opcode.set(currentOpcode).applyRule().with(0, code).result();
        //Assert
        Assertions.assertThat(code).isEqualTo(Arrays.asList(400,6,6,0,99,0,20));
    }

    @Test
    public void whenOpcodeIs2AndParametersAreOutOfBoundsWithTerminationThenResultIsTerminate() {
        //Arrange
        List<Integer> code = Arrays.asList(2,5,5,0,99);
        int currentOpcode = code.get(0);
        //Act
        Result result = Opcode.set(currentOpcode).applyRule().with(0, code).result();
        //Assert
        Assertions.assertThat(result.getType()).isEqualTo(ResultType.TERMINATE);
    }

    @Test
    public void whenOpcodeIs1AndParametersAreOutOfBoundsWithTerminationThenResultIsTerminate() {
        //Arrange
        List<Integer> code = Arrays.asList(1,5,5,0,99);
        int currentOpcode = code.get(0);
        //Act
        Result result = Opcode.set(currentOpcode).applyRule().with(0, code).result();
        //Assert
        Assertions.assertThat(result.getType()).isEqualTo(ResultType.TERMINATE);
    }

    @Test
    public void whenOpcodeIs1AndParametersAre1And1And0WithNoTerminateThenResultIs2_1_1_0() {
        //Arrange
        List<Integer> code = Arrays.asList(1,1,1,0);
        int currentOpcode = code.get(0);
        //Act
        Opcode.set(currentOpcode).applyRule().with(0, code);
        //Assert
        Assertions.assertThat(code).isEqualTo(Arrays.asList(2,1,1,0));
    }

    @Test
    public void whenOpcodeIsRunWithInputThenResultIs_3101844() {
        //Arrange
        List<Integer> code = File.DAY2_1.importFile().stream().map(Integer::valueOf).collect(Collectors.toList());
        code.set(1, 12);
        code.set(2, 2);
        //Act
        IntCode intCode = new IntCode(code);
        intCode.computeCode();
        //Assert
        Assertions.assertThat(code.get(0)).isEqualTo(3101844);
    }

    @Test
    public void whenRunningPart2AndCodeIsOtherInputThenResultIs2347() {
        List<Integer> code = File.DAY2_2.importFile().stream().map(Integer::valueOf).collect(Collectors.toList());
        String answer = "";
        IntCode intCode = new IntCode(code);
        Pairs pairs = intCode.getInputParametersForOutputWithAddress(19690720, 0);
        switch (pairs.getType()) {
            case VALID:
                InputPairs inputPairs = (InputPairs) pairs;
                answer = (100*inputPairs.getNoun() + inputPairs.getVerb()) + "";
                break;
            case INVALID:
            default: answer = "";
        }

        Assertions.assertThat(answer).isEqualTo("2347");
    }

    @Test
    public void whenRunningPart2AndCodeIsNormalInputThenResultIs8478() {
        List<Integer> code = File.DAY2_1.importFile().stream().map(Integer::valueOf).collect(Collectors.toList());
        String answer = "";
        IntCode intCode = new IntCode(code);
        Pairs pairs = intCode.getInputParametersForOutputWithAddress(19690720, 0);
        switch (pairs.getType()) {
            case VALID:
                InputPairs inputPairs = (InputPairs) pairs;
                answer = (100*inputPairs.getNoun() + inputPairs.getVerb()) + "";
                break;
            case INVALID:
            default: answer = "";
        }

        Assertions.assertThat(answer).isEqualTo("8478");
    }

}

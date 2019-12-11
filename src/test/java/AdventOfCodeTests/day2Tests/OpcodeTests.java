package AdventOfCodeTests.day2Tests;

import AdventOfCode.day2.Opcode;
import AdventOfCode.day2.rule.Rule;
import AdventOfCode.day2.rule.Rules;
import org.assertj.core.api.Assertions;
import org.junit.Test;

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

}

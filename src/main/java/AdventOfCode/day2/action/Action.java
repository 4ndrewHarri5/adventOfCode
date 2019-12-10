package AdventOfCode.day2.action;

import AdventOfCode.day2.result.Result;

public interface Action {

    void perform (Result result);

}

// Opcode Action = opcode + operand1Position + operand2Position + storageLocation

// Action = (opcode -> Rule) + storageLocation
/*

types of actions

Add
Multiply
Terminate

 */

/*

Opcode performs Action on Data ( List )

example

1 performs add on 2 numbers and adds that to data

Action.apply(1).with(2,3).when

Action.apply(1) -> Action

Action has a method
with() that takes 2 numbers

returns Result

Result has a method .save

Opcode produces a rule, a rule then produces an action. The action does something on the data



 */
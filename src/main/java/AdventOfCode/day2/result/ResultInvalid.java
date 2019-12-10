package AdventOfCode.day2.result;

import AdventOfCode.day2.action.Action;

public class ResultInvalid extends Result {

    @Override
    public ResultType getType() {
        return ResultType.INVALID;
    }

    @Override
    public void perform(Action action) {
        action.perform(this);
    }

    @Override
    public Result result() {
        return this;
    }
}

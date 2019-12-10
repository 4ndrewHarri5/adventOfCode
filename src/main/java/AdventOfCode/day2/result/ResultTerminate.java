package AdventOfCode.day2.result;

import AdventOfCode.day2.action.Action;

public class ResultTerminate extends Result {

    @Override
    public ResultType getType() {
        return ResultType.TERMINATE;
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

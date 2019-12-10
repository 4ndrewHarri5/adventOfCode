package AdventOfCode.day2.result;

import AdventOfCode.day2.action.Action;

public class ResultNextIndex extends Result {

    private final int nextIndex;

    public ResultNextIndex(int nextIndex) {
        this.nextIndex = nextIndex;
    }

    public int getNumber() {
        return nextIndex;
    }

    @Override
    public ResultType getType() {
        return ResultType.NEXTINDEX;
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

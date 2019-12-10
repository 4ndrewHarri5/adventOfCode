package AdventOfCode.day2.result;

import AdventOfCode.day2.action.Action;

public class ResultNumber extends Result {

    private final int number;
    private final int indexToStore;
    private final int newIndex;

    public ResultNumber(int number, int indexToStore, int newIndex) {
        this.number = number;
        this.indexToStore = indexToStore;
        this.newIndex = newIndex;
    }

    public int getNumber() {
        return number;
    }

    public int getIndexToStore() {
        return indexToStore;
    }

    public int getNewIndex() {
        return newIndex;
    }

    @Override
    public ResultType getType() {
        return ResultType.NUMBER;
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

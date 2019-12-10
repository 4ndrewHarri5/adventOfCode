package AdventOfCode.day2.result;

import AdventOfCode.day2.action.Action;

public abstract class Result{

    abstract public ResultType getType();

    abstract public void perform(Action action);

    abstract public Result result();

    public static Result number(int newNumber, int indexToStore, int newIndex) {
        return new ResultNumber(newNumber, indexToStore, newIndex);
    }

    public static Result terminate() {
        return new ResultTerminate();
    }

    public static Result invalid() {
        return new ResultInvalid();
    }


    /*public void perform(Action action) {
        action.perform(this);
    }*/

}

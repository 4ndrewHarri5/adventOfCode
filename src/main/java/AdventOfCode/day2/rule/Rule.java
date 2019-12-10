package AdventOfCode.day2.rule;

import AdventOfCode.day2.result.Result;

import java.util.List;

@FunctionalInterface
public interface Rule {

    Result with(int currentIndex, List<Integer> code);

}

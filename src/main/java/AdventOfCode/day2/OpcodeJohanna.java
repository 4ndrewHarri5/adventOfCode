package AdventOfCode.day2;
import AdventOfCode.File;
import AdventOfCode.Runner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OpcodeJohanna implements Runner {

    private int MAX_ITERATIONS = 99;
    private int RESULT_AT_0_FOR_REVERSE = 19690720;

    private List<Integer> computer(List<Integer> integers) {
        checkForResult(integers, RESULT_AT_0_FOR_REVERSE);
        /*if (FeatureHandler.FEATURE_REVERSE) {
            checkForResult(integers, RESULT_AT_0_FOR_REVERSE);
        } else {
            if (FeatureHandler.FEATURE_RESTORE_GRAVITY_ASSIST) {
                updatePositionsPartOne(integers);
            } else if (FeatureHandler.FEATURE_TEST_RESULT) {
                updatePositionsTest(integers);
            }
            opcodeDecoder(integers);
        }*/
        return integers;
    }

    private void opcodeDecoder(List<Integer> integers) {
        for (int i = 0; i < integers.size(); i += 4) {
            if (integers.get(i) == 1) {
                Integer firstPosition = integers.get(i + 1);
                Integer secondPosition = integers.get(i + 2);
                Integer replaceAt = integers.get(i + 3);
                Integer sum = integers.get(firstPosition) + integers.get(secondPosition);
                integers.set(replaceAt, sum);

            } else if (integers.get(i) == 2) {
                Integer firstPosition = integers.get(i + 1);
                Integer secondPosition = integers.get(i + 2);
                Integer replaceAt = integers.get(i + 3);
                Integer sum = integers.get(firstPosition) * integers.get(secondPosition);
                integers.set(replaceAt, sum);
            } else if (integers.get(i) == 99) {
                break;
            } else {
                System.out.println("invalid");
            }
        }
    }

    private void checkForResult(List<Integer> integers, int resultAt0) {

        List<Integer> integersAfter = new ArrayList<>(integers);
        List<Integer> integersInitial = new ArrayList<>(integers);

        for (int i = 0; i < MAX_ITERATIONS; i++) {
            if (integersAfter.get(0) < resultAt0) {
                while (integersAfter.get(0) < resultAt0) {
                    //System.out.println(integersAfter.get(0));
                    opcodeDecoder(integersInitial);
                    integersAfter.clear();
                    integersAfter.addAll(integersInitial);
                    integersInitial.clear();
                    integersInitial.addAll(integers);
                    integersInitial.set(1, (integersAfter.get(1) + 1));
                }
            } else if (integersAfter.get(0) > resultAt0) {
                integers.set(2, integers.get(2) + 1);
                integersInitial.clear();
                integersInitial.addAll(integers);
                integersAfter.clear();
                integersAfter.addAll(integersInitial);
            } else {
                System.out.println("equals!");
                System.out.println(integersAfter.get(1));
                System.out.println(integers.get(2));
                integers.set(0, integersAfter.get(0));
                break;
            }
        }
    }
    @Override
    public String run() {
        List<Integer> inputFile = File.DAY2_1.importFile().stream().map(Integer::valueOf).collect(Collectors.toList());
        return computer(inputFile).get(0).toString();
    }
}
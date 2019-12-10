package AdventOfCode.day2.util;

import java.util.Arrays;
import java.util.List;

public class ListChecker {

    public static boolean isIndexesOkay(List<Integer> code, int... indexes) {
        for (Integer index: indexes) {
            if (index >= code.size()) {
                return false;
            }
        }
        return true;
    }

}

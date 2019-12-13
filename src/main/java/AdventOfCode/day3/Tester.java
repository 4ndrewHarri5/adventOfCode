package AdventOfCode.day3;

import java.util.Arrays;
import java.util.List;

public class Tester {

    public static void main(String[] args) {
        List<String> input = Arrays.asList("U4,R3,U2,L2,D1,L2,D3,L3", "L2,U4,L1,U1,R1,U1,R2,D1");
        CrossedWire crossedWire = new CrossedWire(input);

        long startTime = System.nanoTime();
        List<Path> paths = crossedWire.convertInputToPaths();
        List<Coordinate> allDuplicateCoordinates = crossedWire.getAllDuplicateCoordinates(paths);
        long endTime = System.nanoTime();
        System.out.println("Took "+(endTime - startTime) + " ns");
        System.out.println("allDuplicateCoordinates = " + allDuplicateCoordinates);
    }
}

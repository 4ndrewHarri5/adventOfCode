package AdventOfCode.day1;
import AdventOfCode.File;
import AdventOfCode.Runner;

import java.util.ArrayList;
import java.util.List;

public class FuelCalculator implements Runner {

    private List<Integer> masses;

    public FuelCalculator() {
        getMasses();
    }

    private void getMasses() {
        masses = new ArrayList<>();
        File.DAY1_1
                .importFile()
                .forEach(line -> masses.add(convertStringToInteger(line)));
    }

    private Integer convertStringToInteger(String s) {
        return Integer.valueOf(s);
    }

    private Integer calculateFuelRequirement() {
        return masses.stream()
                .map(mass -> calculateFuelForMass(mass, mass))
                .reduce(0, Integer::sum);
    }

    private Integer calculateFuelForMass(Integer startingMass, Integer mass) {
        if (mass > 0) {
            if (mass.equals(startingMass)) {
                return calculateFuelForMass(startingMass, (mass / 3) - 2);
            } else {
                return mass + calculateFuelForMass(startingMass, (mass / 3) - 2);
            }
        }
        return 0;
    }


    @Override
    public String run() {
        return calculateFuelRequirement().toString();
    }
}

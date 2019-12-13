package AdventOfCode.day3;

import java.util.ArrayList;
import java.util.List;

public class Path {

    private List<Coordinate> coordinates;

    public void addCoordinate(Coordinate coordinate) {
        coordinates = new ArrayList<>();
        coordinates.add(coordinate);
    }

    public void addCoordinates(List<Coordinate> addedCoordinates) {
        coordinates.addAll(addedCoordinates);
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    public void removeCoordinate(Coordinate coordinate) {
        coordinates.remove(coordinate);
    }

    @Override
    public String toString() {
        return ""+ coordinates;
    }
}

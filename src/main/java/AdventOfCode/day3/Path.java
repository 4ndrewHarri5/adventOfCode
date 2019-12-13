package AdventOfCode.day3;

import java.util.List;

public class Path {

    private List<Coordinate> coordinates;

    public void addCoordinate(Coordinate coordinate) {
        coordinates.add(coordinate);
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }
}

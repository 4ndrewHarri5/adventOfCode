package AdventOfCode.day3;

public class Distance {

    private final Coordinate coordinate;
    private final int distance;

    public Distance(Coordinate coordinate, int distance) {
        this.coordinate = coordinate;
        this.distance = distance;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public int getDistance() {
        return distance;
    }
}

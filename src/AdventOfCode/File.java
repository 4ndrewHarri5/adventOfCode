package AdventOfCode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public enum File {

    DAY1_1("/Users/harrisa/dev/learning/adventOfCode/adventOfCode/inputFiles/input_day1.txt");

    String file;

    File(String file) {
        this.file = file;
    }

    public Stream<String> importFile() {
        Stream<String> lines = Stream.empty();
        try {
            Path path = Paths.get(file);
            lines = Files.lines(path);
        }catch(IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

}

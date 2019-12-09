package AdventOfCode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum File {

    DAY1_1("/Users/harrisa/dev/learning/adventOfCode/adventOfCode/inputFiles/input_day1.txt"),
    DAY2_1("/Users/harrisa/dev/learning/adventOfCode/adventOfCode/inputFiles/input_day2_1.txt");

    String file;

    File(String file) {
        this.file = file;
    }

    public List<String> importFile() {
        switch (this) {
            case DAY1_1: return importFileByLines();
            case DAY2_1: return importFileSplitByComma();
            default: throw new RuntimeException("file does not exist");
        }
    }

    private List<String> importFileByLines() {
        List<String> lines = new ArrayList<>();
        try {
            Path path = Paths.get(file);
            lines = Files.lines(path).collect(Collectors.toList());
        }catch(IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    private List<String> importFileSplitByComma() {
        List<String> line = new ArrayList<>();
        try {
            Path path = Paths.get(file);
            line = Arrays.asList(Files.readString(path).split(","));
        }catch(IOException e) {
            e.printStackTrace();
        }
        return line;
    }




}

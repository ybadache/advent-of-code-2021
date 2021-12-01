import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Day1Main {

    public static void main(String[] args) throws IOException, URISyntaxException {
        final Day1Puzzle1 day1Puzzle1 = new Day1Puzzle1();
        final List<String> inputDay1Puzzle1 = new ArrayList<>();

        URL url = Day1Main.class.getResource("input.txt");

        Stream<String> fileLines = Files.lines(Paths.get(url.toURI().getPath()));
        fileLines.forEach(line -> inputDay1Puzzle1.add(line));

        int firstAnswer = day1Puzzle1.resolve(inputDay1Puzzle1);
        System.out.println("Answer day 1 puzzle 1: " + firstAnswer);
    }
}

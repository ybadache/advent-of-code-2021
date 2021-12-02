package com.ybadache.advent.day2;

import com.ybadache.advent.day1.Day1Main;
import com.ybadache.advent.day2.puzzle1.Day2Puzzle1;
import com.ybadache.advent.day2.puzzle2.Day2Puzzle2;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Day2Main {
    public static void main(String[] main) throws URISyntaxException, IOException {
        final Day2Puzzle1 day2Puzzle1 = new Day2Puzzle1();
        final Day2Puzzle2 day2Puzzle2 = new Day2Puzzle2();
        final List<String> inputDay2 = new ArrayList<>();

        URL url = Day1Main.class.getClassLoader().getResource("input_day2.txt");

        Stream<String> fileLines = Files.lines(Paths.get(url.toURI().getPath()));
        fileLines.forEach(line -> inputDay2.add(line));

        final int firstAnswer = day2Puzzle1.resolve(inputDay2);
        System.out.println("Answer day 2 puzzle 1 : " + firstAnswer);

        final int secondAnswer = day2Puzzle2.resolve(inputDay2);
        System.out.println("Answer day 2 puzzle 2 : " + secondAnswer);
    }
}

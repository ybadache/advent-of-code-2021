package com.ybadache.advent.day6;

import com.ybadache.advent.day6.puzzle1.Day6Puzzle1;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Day6Main {
    public static void main(String[] args) throws URISyntaxException, IOException {
        final Day6Puzzle1 day6Puzzle1 = new Day6Puzzle1();
        //final Day5Puzzle2 day5Puzzle2 = new Day5Puzzle2();
        final List<String> inputDay6 = new ArrayList<>();

        URL url = Day6Main.class.getClassLoader().getResource("input.txt");

        Stream<String> fileLines = Files.lines(Paths.get(url.toURI().getPath()));
        fileLines.forEach(line -> inputDay6.add(line));

        final int firstAnswer = day6Puzzle1.resolve(inputDay6);
        System.out.println("Answer day 6 puzzle 1 : " + firstAnswer);

        //final int secondAnswer = day6Puzzle2.resolve(inputDay6);
        //System.out.println("Answer day 6 puzzle 2 : " + secondAnswer);
    }
}

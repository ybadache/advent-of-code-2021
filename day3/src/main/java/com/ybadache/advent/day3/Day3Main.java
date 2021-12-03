package com.ybadache.advent.day3;

import com.ybadache.advent.day3.puzzle1.Day3Puzzle1;
import com.ybadache.advent.day3.puzzle2.Day3Puzzle2;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Day3Main {
    public static void main(String[] args) throws URISyntaxException, IOException {
        final Day3Puzzle1 day3Puzzle1 = new Day3Puzzle1();
        final Day3Puzzle2 day3Puzzle2 = new Day3Puzzle2();
        final List<String> inputDay3 = new ArrayList<>();

        URL url = Day3Main.class.getClassLoader().getResource("input.txt");

        Stream<String> fileLines = Files.lines(Paths.get(url.toURI().getPath()));
        fileLines.forEach(line -> inputDay3.add(line));

        final int firstAnswer = day3Puzzle1.resolve(inputDay3);
        System.out.println("Answer day 3 puzzle 1 : " + firstAnswer);

        final int secondAnswer = day3Puzzle2.resolve(inputDay3);
        System.out.println("Answer day 3 puzzle 2 : " + secondAnswer);
    }
}

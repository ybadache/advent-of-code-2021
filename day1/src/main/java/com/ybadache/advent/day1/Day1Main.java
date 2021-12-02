package com.ybadache.advent.day1;

import com.ybadache.advent.day1.puzzle1.Day1Puzzle1;
import com.ybadache.advent.day1.puzzle2.Day1Puzzle2;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Day1Main {

    public static void main(String[] args) throws IOException, URISyntaxException {
        final Day1Puzzle1 day1Puzzle1 = new Day1Puzzle1();
        final List<String> inputDay1 = new ArrayList<>();

        URL url = Day1Main.class.getClassLoader().getResource("input_day1.txt");

        Stream<String> fileLines = Files.lines(Paths.get(url.toURI().getPath()));
        fileLines.forEach(line -> inputDay1.add(line));

        int firstAnswer = day1Puzzle1.resolve(inputDay1);
        System.out.println("Answer day 1 puzzle 1: " + firstAnswer);

        final Day1Puzzle2 day1Puzzle2 = new Day1Puzzle2();
        int secondAnswer = day1Puzzle2.resolve(inputDay1);
        System.out.println("Answer day 1 puzzle 2: " + secondAnswer);
    }
}

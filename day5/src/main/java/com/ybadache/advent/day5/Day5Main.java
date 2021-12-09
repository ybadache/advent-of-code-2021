package com.ybadache.advent.day5;

import com.ybadache.advent.day5.puzzle1.Day5Puzzle1;
import com.ybadache.advent.day5.puzzle2.Day5Puzzle2;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Day5Main {
    public static void main(String[] args) throws URISyntaxException, IOException {
        final Day5Puzzle1 day5Puzzle1 = new Day5Puzzle1();
        final Day5Puzzle2 day5Puzzle2 = new Day5Puzzle2();
        final List<String> inputDay5 = new ArrayList<>();

        URL url = Day5Main.class.getClassLoader().getResource("input.txt");

        Stream<String> fileLines = Files.lines(Paths.get(url.toURI().getPath()));
        fileLines.forEach(line -> inputDay5.add(line));

        final int firstAnswer = day5Puzzle1.resolve(inputDay5);
        System.out.println("Answer day 5 puzzle 1 : " + firstAnswer);

        final int secondAnswer = day5Puzzle2.resolve(inputDay5);
        System.out.println("Answer day 5 puzzle 2 : " + secondAnswer);
    }
}

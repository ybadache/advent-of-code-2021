package com.ybadache.advent.day4;

import com.ybadache.advent.day4.puzzle1.Day4Puzzle1;
import com.ybadache.advent.day4.puzzle2.Day4Puzzle2;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Day4Main {
    public static void main(String[] args) throws URISyntaxException, IOException {
        final Day4Puzzle1 day4Puzzle1 = new Day4Puzzle1();
        final Day4Puzzle2 day4Puzzle2 = new Day4Puzzle2();
        final List<String> inputDay4 = new ArrayList<>();

        URL url = Day4Main.class.getClassLoader().getResource("input.txt");

        Stream<String> fileLines = Files.lines(Paths.get(url.toURI().getPath()));
        fileLines.forEach(line -> inputDay4.add(line));

        final int firstAnswer = day4Puzzle1.resolve(inputDay4);
        System.out.println("Answer day 4 puzzle 1 : " + firstAnswer);
    }
}

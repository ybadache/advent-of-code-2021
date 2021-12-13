package com.ybadache.advent.day7;

import com.ybadache.advent.day7.puzzle1.Day7Puzzle1;
import com.ybadache.advent.day7.puzzle2.Day7Puzzle2;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Day7Main {
    public static void main(String[] args) throws URISyntaxException, IOException {
        final Day7Puzzle1 day7Puzzle1 = new Day7Puzzle1();
        final Day7Puzzle2 day7Puzzle2 = new Day7Puzzle2();
        final List<String> inputDay7 = new ArrayList<>();

        // just realized this does not work well on Windows
        URL url = Day7Main.class.getClassLoader().getResource("input.txt");

        Stream<String> fileLines = Files.lines(Paths.get(url.toURI().getPath()));
        fileLines.forEach(line -> inputDay7.add(line));

        System.out.println("Answer day 7 puzzle 1 : " + day7Puzzle1.resolve(inputDay7.get(0)));

        System.out.println("Answer day 7 puzzle 2 : " + day7Puzzle2.resolve(inputDay7.get(0)));
    }
}

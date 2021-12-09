package com.ybadache.advent.day5.puzzle2;

import com.ybadache.advent.day5.puzzle1.Day5Puzzle1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Day5Puzzle2Test {
    private static final List<String> ADVENT_INPUT = Arrays.asList(
            "0,9 -> 5,9",
            "8,0 -> 0,8",
            "9,4 -> 3,4",
            "2,2 -> 2,1",
            "7,0 -> 7,4",
            "6,4 -> 2,0",
            "0,9 -> 2,9",
            "3,4 -> 1,4",
            "0,0 -> 8,8",
            "5,5 -> 8,2");

    @Test
    public void day5Puzzle2SampleTest()     {
        final int expectedAnswer = new Day5Puzzle2().resolve(ADVENT_INPUT);
        Assertions.assertEquals(12, expectedAnswer);
    }
}

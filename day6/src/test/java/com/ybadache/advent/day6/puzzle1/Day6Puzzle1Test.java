package com.ybadache.advent.day6.puzzle1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Day6Puzzle1Test {

    @Test
    public void day6Puzzle1SampleTest()     {
        final List<String> input = Arrays.asList(
                "3,4,3,1,2");

        final int expectedAnswer = new Day6Puzzle1().resolve(input);
        Assertions.assertEquals(5934, expectedAnswer);

        final int expectedFasterAnswer = new Day6Puzzle1Faster().resolve(input);
        Assertions.assertEquals(5934, expectedFasterAnswer);
    }
}

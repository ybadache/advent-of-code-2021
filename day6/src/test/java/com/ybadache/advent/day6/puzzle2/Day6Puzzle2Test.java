package com.ybadache.advent.day6.puzzle2;

import com.ybadache.advent.day6.puzzle1.Day6Puzzle1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class Day6Puzzle2Test {

    @Test
    public void day6Puzzle2SampleTest()     {
        final List<String> input = Arrays.asList(
                "3,4,3,1,2");

        final long expectedAnswer = new Day6Puzzle2().resolve(input);
        Assertions.assertEquals(26984457539L, expectedAnswer);
    }
}

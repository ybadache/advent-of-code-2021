package com.ybadache.advent.day3.puzzle1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day3Puzzle1Test {

    @Test
    public void day3puzzle1EdgeCasesTest()      {
        final Day3Puzzle1 day3Puzzle1 = new Day3Puzzle1();

        final int nullInputResult = day3Puzzle1.resolve(null);
        Assertions.assertEquals(0, nullInputResult);

        final int emptyInputResult = day3Puzzle1.resolve(new ArrayList<>());
        Assertions.assertEquals(0, emptyInputResult);
    }

    @Test
    public void day3puzzle1SimpleCasesTest()    {
        final Day3Puzzle1 day3Puzzle1 = new Day3Puzzle1();

        final int singleInputFullZeros = day3Puzzle1.resolve(Arrays.asList("000000"));
        Assertions.assertEquals(0, singleInputFullZeros);

        final int singleInputFullOnes = day3Puzzle1.resolve(Arrays.asList("1111"));
        Assertions.assertEquals(0, singleInputFullOnes);

        final int singleInputMixed = day3Puzzle1.resolve(Arrays.asList("0011111"));
        Assertions.assertEquals(2976, singleInputMixed);
    }

    @Test
    public void day3puzzle1SampleTest()     {
        final Day3Puzzle1 day3Puzzle1 = new Day3Puzzle1();

        final List<String> input = Arrays.asList(
                "00100",
                "11110",
                "10110",
                "10111",
                "10101",
                "01111",
                "00111",
                "11100",
                "10000",
                "11001",
                "00010",
                "01010");

        final int expectedAnswer = day3Puzzle1.resolve(input);
        Assertions.assertEquals(198, expectedAnswer);
    }
}

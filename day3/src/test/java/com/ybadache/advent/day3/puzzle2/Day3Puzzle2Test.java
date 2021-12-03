package com.ybadache.advent.day3.puzzle2;

import com.ybadache.advent.day3.puzzle1.Day3Puzzle1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day3Puzzle2Test {

    @Test
    public void day3puzzle1EdgeCasesTest()      {
        final Day3Puzzle2 day3Puzzle2 = new Day3Puzzle2();

        final int nullInputResult = day3Puzzle2.resolve(null);
        Assertions.assertEquals(0, nullInputResult);

        final int emptyInputResult = day3Puzzle2.resolve(new ArrayList<>());
        Assertions.assertEquals(0, emptyInputResult);
    }

    @Test
    public void day3puzzle1SimpleCasesTest()    {
        final Day3Puzzle2 day3Puzzle2 = new Day3Puzzle2();

        final int singleInputFullZeros = day3Puzzle2.resolve(Arrays.asList("000000"));
        Assertions.assertEquals(0, singleInputFullZeros);

        final int singleInputFullOnes = day3Puzzle2.resolve(Arrays.asList("1111"));
        Assertions.assertEquals(225, singleInputFullOnes);

        final int singleInputMixed = day3Puzzle2.resolve(Arrays.asList("0011111"));
        Assertions.assertEquals(961, singleInputMixed);
    }

    @Test
    public void day3puzzle2SampleTest()     {
        final Day3Puzzle2 day3Puzzle2 = new Day3Puzzle2();

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

        final int expectedAnswer = day3Puzzle2.resolve(input);
        Assertions.assertEquals(230, expectedAnswer);
    }
}

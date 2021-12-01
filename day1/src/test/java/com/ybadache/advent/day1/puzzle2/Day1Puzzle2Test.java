package com.ybadache.advent.day1.puzzle2;

import com.ybadache.advent.day1.puzzle1.Day1Puzzle1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day1Puzzle2Test {

    @Test
    public void day1Puzzle2EdgeCasesTest() {
        final Day1Puzzle2 day1Puzzle2 = new Day1Puzzle2();

        final int nullInput = day1Puzzle2.resolve(null);
        Assertions.assertEquals(0, nullInput);

        final int emptyInput = day1Puzzle2.resolve(new ArrayList<>());
        Assertions.assertEquals(0, emptyInput);
    }

    @Test
    public void day1Puzzle2SingleSampleTest() {
        final Day1Puzzle2 day1Puzzle2 = new Day1Puzzle2();

        final int singleInput = day1Puzzle2.resolve(Arrays.asList("42"));
        Assertions.assertEquals(0, singleInput);

        final int doubleInput = day1Puzzle2.resolve(Arrays.asList("42", "24"));
        Assertions.assertEquals(0, doubleInput);

        final int tripleInput = day1Puzzle2.resolve(Arrays.asList("24", "42", "77"));
        Assertions.assertEquals(0, tripleInput);

        final int quadInputNoIncrease = day1Puzzle2.resolve(Arrays.asList("24", "42", "77", "15"));
        Assertions.assertEquals(0, quadInputNoIncrease);

        final int quadInputIncrease = day1Puzzle2.resolve(Arrays.asList("24", "42", "77", "43"));
        Assertions.assertEquals(1, quadInputIncrease);
    }

    @Test
    public void day1Puzzle1ExampleInputTest() {
        final Day1Puzzle2 day1Puzzle2 = new Day1Puzzle2();

        final List<String> input = Arrays.asList(
                "199",
                "200",
                "208",
                "210",
                "200",
                "207",
                "240",
                "269",
                "260",
                "263");

        final int answer = day1Puzzle2.resolve(input);

        Assertions.assertEquals(5, answer);
    }
}

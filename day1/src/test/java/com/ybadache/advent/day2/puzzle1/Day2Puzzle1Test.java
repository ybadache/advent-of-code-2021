package com.ybadache.advent.day2.puzzle1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day2Puzzle1Test {

    @Test
    public void day2puzzle1EdgeCasesTest()      {
        final Day2Puzzle1 day2Puzzle1 = new Day2Puzzle1();

        final int nullInputResult = day2Puzzle1.resolve(null);
        Assertions.assertEquals(0, nullInputResult);

        final int emptyInputResult = day2Puzzle1.resolve(new ArrayList<>());
        Assertions.assertEquals(0, emptyInputResult);
    }

    @Test
    public void day2puzzle1SimpleSamplesTest()      {
        final Day2Puzzle1 day2Puzzle1 = new Day2Puzzle1();

        final int onlyOneForward = day2Puzzle1.resolve(Arrays.asList("forward 8"));
        Assertions.assertEquals(0, onlyOneForward);

        final int onlyOneUp = day2Puzzle1.resolve(Arrays.asList("up 7"));
        Assertions.assertEquals(0, onlyOneUp);

        final int onlyOneDown = day2Puzzle1.resolve(Arrays.asList("down 1"));
        Assertions.assertEquals(0, onlyOneDown);

        final int multipleForwardsOnly = day2Puzzle1.resolve(Arrays.asList("forward 8", "forward 1", "forward 14"));
        Assertions.assertEquals(0, multipleForwardsOnly);

        final int multipleDownOnly = day2Puzzle1.resolve(Arrays.asList("up 1", "up 2", "up 3", "up 4"));
        Assertions.assertEquals(0, multipleDownOnly);

        final int multipleUpOnly = day2Puzzle1.resolve(Arrays.asList("down 4", "down 3", "down 99"));
        Assertions.assertEquals(0, multipleUpOnly);

        final int multipleUpsAndDowns = day2Puzzle1.resolve(Arrays.asList("up 1", "down 2", "up 3", "down 4"));
        Assertions.assertEquals(0, multipleUpsAndDowns);

        final int oneOfEach = day2Puzzle1.resolve(Arrays.asList("forward 2", "up 5", "down 7"));
        Assertions.assertEquals(4, oneOfEach);
    }

    @Test
    public void day2puzzle1SampleTest()     {
        final Day2Puzzle1 day2Puzzle1 = new Day2Puzzle1();

        final List<String> input = Arrays.asList(
                "forward 5",
                "down 5",
                "forward 8",
                "up 3",
                "down 8",
                "forward 2");

        final int expectedResult = day2Puzzle1.resolve(input);
        Assertions.assertEquals(150, expectedResult);
     }
}

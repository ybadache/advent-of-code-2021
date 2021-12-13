package com.ybadache.advent.day7.puzzle1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day7Puzzle1Test {

    @Test
    public void day7Puzzle1Test()       {
        final String input = "16,1,2,0,4,2,7,1,2,14";

        final int expectedAnswer = new Day7Puzzle1().resolve(input);
        Assertions.assertEquals(37, expectedAnswer);
    }
}

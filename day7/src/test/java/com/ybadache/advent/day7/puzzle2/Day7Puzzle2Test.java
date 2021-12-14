package com.ybadache.advent.day7.puzzle2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day7Puzzle2Test {

    @Test
    public void day7Puzzle2SampleTest()     {
        final String input = "16,1,2,0,4,2,7,1,2,14";

        final int expectedAnswer = new Day7Puzzle2().resolve(input);
        Assertions.assertEquals(168, expectedAnswer);
    }

    /**
     * This one StacksOverflow but I'm proud, I did it one shot
     */
    @Test
    public void sumOfNumbersRecursiveTest()      {
        final int zeroSum = new Day7Puzzle2().sumOfNumbersRecursive(0);
        Assertions.assertEquals(0, zeroSum);

        final int oneSum = new Day7Puzzle2().sumOfNumbersRecursive(1);
        Assertions.assertEquals(1, oneSum);

        final int twoSum = new Day7Puzzle2().sumOfNumbersRecursive(2);
        Assertions.assertEquals(3, twoSum);

        final int fiveSum = new Day7Puzzle2().sumOfNumbersRecursive(5);
        Assertions.assertEquals(15, fiveSum);

        final int elevenSum = new Day7Puzzle2().sumOfNumbersRecursive(11);
        Assertions.assertEquals(66, elevenSum);
    }

    @Test
    public void sumOfNumbersTest()      {
        final int zeroSum = new Day7Puzzle2().sumOfNumbers(0);
        Assertions.assertEquals(0, zeroSum);

        final int oneSum = new Day7Puzzle2().sumOfNumbers(1);
        Assertions.assertEquals(1, oneSum);

        final int twoSum = new Day7Puzzle2().sumOfNumbers(2);
        Assertions.assertEquals(3, twoSum);

        final int fiveSum = new Day7Puzzle2().sumOfNumbers(5);
        Assertions.assertEquals(15, fiveSum);

        final int elevenSum = new Day7Puzzle2().sumOfNumbers(11);
        Assertions.assertEquals(66, elevenSum);
    }
}

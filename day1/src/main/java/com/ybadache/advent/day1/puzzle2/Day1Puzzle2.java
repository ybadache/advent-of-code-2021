package com.ybadache.advent.day1.puzzle2;

import java.util.List;
import java.util.Objects;

public class Day1Puzzle2 {

    public int resolve(List<String> input)  {
        if (Objects.isNull(input) || input.size() <= 3)     {
            return 0;
        }

        int numberOfIncreases = 0;
        final int inputSize = input.size() - 4;

        for (int i = 0; i <= inputSize; i++)    {
            if (Integer.valueOf(input.get(i)) < Integer.valueOf(input.get(i + 3)))    {
                numberOfIncreases++;
            }
        }
        return numberOfIncreases;
    }
}

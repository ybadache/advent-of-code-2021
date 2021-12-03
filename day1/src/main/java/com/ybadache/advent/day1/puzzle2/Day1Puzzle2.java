package com.ybadache.advent.day1.puzzle2;

import com.ybadache.advent.commons.utils.ObjectCheckingUtils;

import java.util.List;

public class Day1Puzzle2 {

    public int resolve(List<String> input)  {
        if (ObjectCheckingUtils.isListNullOrEmpty(input) )     {
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

package com.ybadache.advent.day1.puzzle1;


import com.ybadache.advent.commons.utils.ObjectCheckingUtils;

import java.util.List;

public class Day1Puzzle1 {

    public int resolve(List<String> input)  {
        if (ObjectCheckingUtils.isListNullOrEmpty(input))     {
            return 0;
        }

        int numberOfIncreases = 0;
        int oracle = Integer.valueOf(input.get(0));
        for (String number : input)     {
            if (Integer.valueOf(number) > oracle)   {
                numberOfIncreases++;
            }

            oracle = Integer.valueOf(number);
        }

        return numberOfIncreases;
    }
}

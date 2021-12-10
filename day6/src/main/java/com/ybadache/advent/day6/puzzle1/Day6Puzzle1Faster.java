package com.ybadache.advent.day6.puzzle1;

import java.util.Arrays;
import java.util.List;

/*
    By not counting like a dumb ass the fishes in a straight list,
    but rather aggregate the number of fishes on a particular state,
    we can speed up the process drastically.
    There are 8 states, from
    day 0 to day 8.
 */
public class Day6Puzzle1Faster {

    private static final int DAYS_TO_WAIT = 80;
    private static final int MATURITY = 8;

    public int resolve(List<String> input)  {
        // the input is a one liner
        int[] fishesInStates = new int[10];

        // we start by initializing the array with our current input
        for(String state : input.get(0).split(","))     {
            fishesInStates[Integer.parseInt(state)]++;
        }

        for (int currentDay = 0; currentDay < DAYS_TO_WAIT; currentDay++)   {
            fishesInStates[7] += fishesInStates[0];
            fishesInStates[9] = fishesInStates[0];

            for (int state = 0; state <= MATURITY; state++)    {
                fishesInStates[state] = fishesInStates[state + 1];
            }

            fishesInStates[9] = 0;
        }

        return Arrays.stream(fishesInStates).sum();
    }
}

package com.ybadache.advent.day6.puzzle2;

import java.util.Arrays;
import java.util.List;

/*
    Actually works for the second problem too
 */
public class Day6Puzzle2 {
    private static final int DAYS_TO_WAIT = 256;
    private static final int MATURITY = 8;

    public long resolve(List<String> input)  {
        // the input is a one liner
        long[] fishesInStates = new long[10];

        // we start by initializing the array with our current input
        for(String state : input.get(0).split(","))     {
            fishesInStates[Integer.parseInt(state)]++;
        }

        for (int currentDay = 0; currentDay < DAYS_TO_WAIT; currentDay++)   {
            // state[7] = fishes that reached 8
            fishesInStates[7] += fishesInStates[0];

            // fishes[9] = buffer to store fishes that reached end of maturity
            fishesInStates[9] = fishesInStates[0];

            for (int state = 0; state <= MATURITY; state++)    {
                fishesInStates[state] = fishesInStates[state + 1];
            }

            fishesInStates[9] = 0;
        }

        return Arrays.stream(fishesInStates).sum();
    }
}

package com.ybadache.advent.day7.puzzle1;

public class Day7Puzzle1 {
    public int resolve(String input)    {

        String[] positionsString = input.split(",");
        int[] positions = new int[positionsString.length];
        for (int i = 0; i < positionsString.length; i++)    {
            positions[i] = Integer.parseInt(positionsString[i]);
        }

        int result = 9999;
        for (int i = 0; i < positions.length; i++)      {
            int totalFuelNeeded = 0;
            for (int j = 0; j < positions.length; j++)  {
                totalFuelNeeded += Math.abs(positions[i] - positions[j]);
            }

            result = Math.min(result, totalFuelNeeded);
        }

        return result;
    }
}

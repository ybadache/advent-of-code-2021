package com.ybadache.advent.day7.puzzle2;


/**
 * Always starting by a dumb algorithm, I'll see later to improve it
 */
public class Day7Puzzle2 {
    public int resolve(String input) {

        String[] positionsString = input.split(",");
        int[] positions = new int[positionsString.length];
        for (int i = 0; i < positionsString.length; i++) {
            positions[i] = Integer.parseInt(positionsString[i]);
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < positions.length; i++) {
            int totalFuelNeeded = 0;
            for (int j = 0; j < positions.length; j++) {
                totalFuelNeeded += this.sumOfNumbersRecursive(Math.abs(i - positions[j]));
            }

            result = Math.min(result, totalFuelNeeded);
        }

        return result;
    }

    public int sumOfNumbersRecursive(int positionShift) {
        if (positionShift == 0)     {
            return 0;
        }  else  {
            return positionShift + this.sumOfNumbersRecursive(positionShift - 1);
        }
    }

    public int sumOfNumbers(int positionShift) {
        int result = 0;
        for (int i = 0; i <= positionShift; i++)    {
            result += i;
        }
         return result;
    }
}

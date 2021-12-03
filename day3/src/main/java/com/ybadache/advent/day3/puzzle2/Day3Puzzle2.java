package com.ybadache.advent.day3.puzzle2;

import com.ybadache.advent.commons.utils.ObjectCheckingUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day3Puzzle2 {

    public int resolve(List<String> input)    {
        if (ObjectCheckingUtils.isListNullOrEmpty(input) )     {
            return 0;
        }

        int totalInputSize = input.size();


        // All input are considered of equal size so no risks there
        List<String> co2StrubberRating = new ArrayList<>();

        int oxygenGeneratorRating = Integer.parseInt(this.findOxygenGeneratorRating(input, 0), 2);
        int co2ScrubberRating = Integer.parseInt(this.findCo2ScrubberRating(input, 0), 2);

        return oxygenGeneratorRating * co2ScrubberRating;
    }

    private String findOxygenGeneratorRating(List<String> startingList, int index)     {
        if (startingList.size() == 1)   {
            return startingList.get(0);
        }

        int numberOfOnes = 0;
        int numberOfZeros = 0;
        for (String line : startingList)    {
            int parsedInteger = Integer.parseInt(String.valueOf(line.charAt(index)));
            if (parsedInteger == 1)  {
                numberOfOnes++;
            } else if (parsedInteger == 0)    {
                numberOfZeros++;
            }
        }

        if (numberOfOnes >= numberOfZeros)  {
            List<String> allSelectedDigitsAreOne = startingList.stream()
                    .filter(line -> line.charAt(index) == '1')
                    .collect(Collectors.toList());
            return findOxygenGeneratorRating(allSelectedDigitsAreOne, index + 1);
        } else {
            List<String> allSelectedDigitsAreZeroes = startingList.stream()
                    .filter(line -> line.charAt(index) == '0')
                    .collect(Collectors.toList());
            return findOxygenGeneratorRating(allSelectedDigitsAreZeroes, index + 1);
        }
    }

    private String findCo2ScrubberRating(List<String> startingList, int index)     {
        if (startingList.size() == 1)   {
            return startingList.get(0);
        }

        int numberOfOnes = 0;
        int numberOfZeros = 0;
        for (String line : startingList)    {
            int parsedInteger = Integer.parseInt(String.valueOf(line.charAt(index)));
            if (parsedInteger == 1)  {
                numberOfOnes++;
            } else if (parsedInteger == 0)    {
                numberOfZeros++;
            }
        }

        if (numberOfOnes < numberOfZeros)  {
            List<String> allSelectedDigitsAreOne = startingList.stream()
                    .filter(line -> line.charAt(index) == '1')
                    .collect(Collectors.toList());
            return findCo2ScrubberRating(allSelectedDigitsAreOne, index + 1);
        } else {
            List<String> allSelectedDigitsAreZeroes = startingList.stream()
                    .filter(line -> line.charAt(index) == '0')
                    .collect(Collectors.toList());
            return findCo2ScrubberRating(allSelectedDigitsAreZeroes, index + 1);
        }
    }
}

package com.ybadache.advent.day3.puzzle1;

import com.ybadache.advent.commons.utils.ObjectCheckingUtils;

import java.util.List;

public class Day3Puzzle1 {

    public int resolve(List<String> input)    {
        if (ObjectCheckingUtils.isListNullOrEmpty(input) )     {
            return 0;
        }

        final int totalInputSize = input.size();
        final int inputLength = input.get(0).length();
        final StringBuilder gammaRate = new StringBuilder();
        final StringBuilder epsilonRate = new StringBuilder();

        // There surely is a better way. God forgive what I'll write now
        // Update: there was a better way, of course


        // All input are considered of equal size so no risks there
        for (int i = 0; i < inputLength; i++) {
            // to use into stream().filter()
            int characterIndex = i;
            long numberOfOnes = input.stream()
                    .filter(line -> line.charAt(characterIndex) == '1')
                    .count();
            long numberOfZeros = input.stream()
                    .filter(line -> line.charAt(characterIndex) == '0')
                    .count();

            if (numberOfOnes > totalInputSize / 2) {
                gammaRate.append("1");
                epsilonRate.append("0");
            } else if (numberOfZeros > totalInputSize / 2) {
                gammaRate.append("0");
                epsilonRate.append("1");
            }
        }

        return Integer.parseInt(gammaRate.toString(), 2) * Integer.parseInt(epsilonRate.toString(), 2);
    }
}

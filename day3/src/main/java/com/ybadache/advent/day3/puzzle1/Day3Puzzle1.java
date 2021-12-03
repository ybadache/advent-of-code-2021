package com.ybadache.advent.day3.puzzle1;

import com.ybadache.advent.commons.utils.ObjectCheckingUtils;

import java.util.ArrayList;
import java.util.List;

public class Day3Puzzle1 {

    public int resolve(List<String> input)    {
        if (ObjectCheckingUtils.isListNullOrEmpty(input) )     {
            return 0;
        }

        int totalInputSize = input.size();
        String gammaRate = "";
        String epsilonRate = "";

        // There surely is a better way. God forgive what I'll write now
        List<char[]> splittedBinaryInput = new ArrayList<>();
        for (String line : input)   {
            splittedBinaryInput.add(line.toCharArray());
        }


        // All input are considered of equal size so no risks there
        for (int i = 0; i < splittedBinaryInput.get(0).length; i++)     {
            int numberOfOnes = 0;
            int numberOfZeros = 0;
            for (char[] splittedBinary : splittedBinaryInput)   {
                if (splittedBinary[i] == '1')   {
                    numberOfOnes++;
                } else  {
                    numberOfZeros++;
                }

                if (numberOfOnes > totalInputSize / 2)  {
                    gammaRate = gammaRate + "1";
                    epsilonRate = epsilonRate + "0";
                    break;
                } else if (numberOfZeros > totalInputSize / 2)  {
                    gammaRate = gammaRate + "0";
                    epsilonRate = epsilonRate + "1";
                    break;
                }
            }
        }

        gammaRate = gammaRate == "" ? "0" : gammaRate;
        epsilonRate = epsilonRate == "" ? "0" : epsilonRate;
        return Integer.parseInt(gammaRate, 2) * Integer.parseInt(epsilonRate, 2);
    }
}

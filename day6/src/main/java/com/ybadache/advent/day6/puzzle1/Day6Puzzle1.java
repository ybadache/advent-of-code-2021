package com.ybadache.advent.day6.puzzle1;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;

public class Day6Puzzle1 {

    private static final int DAYS_TO_COUNT = 256;

    public int resolve(List<String> input)  {
    List<Fish> schoolOfFishes = new ArrayList<>();

        // the input is a one liner
        final String inputLine = input.get(0);

        // Converting all numbers into the string in integers
        schoolOfFishes.addAll(
            Arrays.stream(inputLine.split(","))
            .map(line -> new Fish(Integer.parseInt(line)))
            .collect(Collectors.toList()));

        List<Fish> nextDaySchoolOfFishes = new ArrayList<>();
        for (int i = 0; i < DAYS_TO_COUNT; i++)     {
            nextDaySchoolOfFishes.addAll(schoolOfFishes);
            for (Fish fish : nextDaySchoolOfFishes)     {
                if (fish.getMaturity() == 0)    {
                    fish.resetMaturity();
                    schoolOfFishes.add(new Fish(8));
                } else  {
                    fish.decreaseMaturity();
                }
            }

            nextDaySchoolOfFishes.removeAll(schoolOfFishes);
        }

        return schoolOfFishes.size();
    }

    public class Fish   {
        private int maturity;

        public Fish(int maturity) {
            this.maturity = maturity;
        }

        public int getMaturity() {
            return maturity;
        }

        public void setMaturity(int maturity) {
            this.maturity = maturity;
        }

        public void resetMaturity()     {
            this.maturity = 6;
        }

        public void decreaseMaturity()      {
            this.maturity--;
        }
    }
}

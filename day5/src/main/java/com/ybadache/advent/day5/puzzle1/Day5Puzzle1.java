package com.ybadache.advent.day5.puzzle1;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Day5Puzzle1 {

    private static final int MAX_MATRIX_SIZE = 1000;
    private static final int[][] VENTS_MATRIX = new int[MAX_MATRIX_SIZE][MAX_MATRIX_SIZE];
    private static int DANGER_ZONES = 0;

    public int resolve(List<String> input) {
        for (String line : input)    {
            // Splitting the line in four parts: x1, x2, y1, y2
            Matcher matcher = Pattern.compile("(\\d*),(\\d*) -> (\\d*),(\\d*)").matcher(line);
            matcher.find();

            // Storing them into coordinates
            int[] coordinates = new int[]{
                    // x1
                    Integer.parseInt(matcher.group(1)),

                    // y1
                    Integer.parseInt(matcher.group(2)),

                    // x2
                    Integer.parseInt(matcher.group(3)),

                    // y2
                    Integer.parseInt(matcher.group(4))
            };

            // if x1 = y1
            if (coordinates[0] == coordinates[2]) {
                // adding x1, x2
                this.add(coordinates[0], coordinates[1]);
                int increment = coordinates[1] > coordinates[3] ? -1 : 1;
                while (coordinates[1] != coordinates[3]) {
                    coordinates[1] += increment;
                    this.add(coordinates[0], coordinates[1]);
                }
            } else if (coordinates[1] == coordinates[3]) {
                // adding x1, x2
                this.add(coordinates[0], coordinates[1]);
                int increment = coordinates[0] > coordinates[2] ? -1 : 1;
                while (coordinates[0] != coordinates[2]) {
                    coordinates[0] += increment;
                    this.add(coordinates[0], coordinates[1]);
                }
            }
        }

        return DANGER_ZONES;
    }

    private void add(int x, int y)  {
        if (++VENTS_MATRIX[x][y] == 2) DANGER_ZONES++;
    }
}

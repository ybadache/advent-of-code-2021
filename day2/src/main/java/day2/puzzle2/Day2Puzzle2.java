package day2.puzzle2;

import com.ybadache.advent.commons.utils.ObjectCheckingUtils;

import java.util.List;

public class Day2Puzzle2 {

    public int resolve(List<String> input)      {
        if (ObjectCheckingUtils.isListNullOrEmpty(input))     {
            return 0;
        }

        int depth = 0;
        int aim = 0;
        int forward = 0;
        for (String line : input)   {
            String[] parsedLine = line.split("\\s+");

            switch(parsedLine[0])   {
                case "forward":
                    forward += Integer.valueOf(parsedLine[1]);
                    depth += aim * Integer.valueOf(parsedLine[1]);
                    break;
                case "up":
                    aim -= Integer.valueOf(parsedLine[1]);
                    break;
                case "down":
                    aim += Integer.valueOf(parsedLine[1]);
                    break;
            }
        }

        return depth * forward;
    }
}

package day2.puzzle2;

import java.util.List;
import java.util.Objects;

public class Day2Puzzle2 {

    public int resolve(List<String> input)      {
        if (Objects.isNull(input) || input.size() == 0)     {
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

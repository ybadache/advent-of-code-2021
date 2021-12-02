package day2.puzzle1;

import java.util.List;
import java.util.Objects;

public class Day2Puzzle1 {

    /*
        Two things:
        1) the complexity is 12, which is terrible
        2) there are better ways to do this with Streams I'm sure.
        For instance, you could filter and add all forwards, then all ups and downs, then simply
        operate a multiply
     */
    public int resolve(List<String> input)  {
        if (Objects.isNull(input) || input.size() == 0)     {
            return 0;
        }

        int depth = 0;
        int forward = 0;
        for (String line : input)   {
            String[] parsedLine = line.split("\\s+");

            switch(parsedLine[0])   {
                case "forward":
                    forward += Integer.valueOf(parsedLine[1]);
                    break;
                case "up":
                    depth -= Integer.valueOf(parsedLine[1]);
                    break;
                case "down":
                    depth += Integer.valueOf(parsedLine[1]);
                    break;
            }
        }

        return depth * forward;
    }
}

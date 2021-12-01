import java.util.List;
import java.util.Objects;

public class Day1Puzzle1 {

    public int resolve(List<String> input)  {
        if (Objects.isNull(input) || input.size() == 0)     {
            return 0;
        }

        int numberOfIncreases = 0;
        int oracle = Integer.valueOf(input.get(0));
        for (String number : input)     {
            if (Integer.valueOf(number) > oracle)   {
                numberOfIncreases++;
            }

            oracle = Integer.valueOf(number);
        }

        return numberOfIncreases;
    }
}

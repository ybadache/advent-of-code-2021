import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day1Test   {

    @Test
    public void day1Puzzle1EdgeCasesTest()     {
        final Day1Puzzle1 day1Puzzle1 = new Day1Puzzle1();

        final int nullInput = day1Puzzle1.resolve(null);
        Assertions.assertEquals(0, nullInput);

        final int emptyInput = day1Puzzle1.resolve(new ArrayList<>());
        Assertions.assertEquals(0, emptyInput);
    }

    @Test
    public void day1Puzzle1SingleSampleTest()   {
        final Day1Puzzle1 day1Puzzle1 = new Day1Puzzle1();

final int singleInput = day1Puzzle1.resolve(Arrays.asList("42"));
        Assertions.assertEquals(0, singleInput);

        final int dualInputNoIncrease = day1Puzzle1.resolve(Arrays.asList("42", "24"));
        Assertions.assertEquals(0, dualInputNoIncrease);

        final int dualInputIncrease = day1Puzzle1.resolve(Arrays.asList("24", "42"));
        Assertions.assertEquals(1, dualInputIncrease);
    }

    @Test
    public void day1Puzzle1ExampleInput()      {
        final Day1Puzzle1 day1Puzzle1 = new Day1Puzzle1();

        final List<String> input = Arrays.asList(
                "199",
                "200",
                "208",
                "210",
                "200",
                "207",
                "240",
                "269",
                "260",
                "263");

        final int answer = day1Puzzle1.resolve(input);

        Assertions.assertEquals(7, answer);
    }
}
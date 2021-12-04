package com.ybadache.advent.day4.puzzle1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Day4Puzzle1Test {

    @Test
    public void extractBingoCardsFromInputTest()    {
        final Day4Puzzle1 day4Puzzle1 = new Day4Puzzle1();

        // Compared to the initial input, we removed the first two lines
        final List<String> input = Arrays.asList(
                "22 13 17 11  0",
                "8  2 23  4 24",
                "21  9 14 16  7",
                "6 10  3 18  5",
                "1 12 20 15 19",
                "\n",
                "3 15  0  2 22",
                "9 18 13 17  5",
                "19  8  7 25 23",
                "20 11 10 24  4",
                "14 21 16 12  6",
                "\n",
                "14 21 17 24  4",
                "10 16 15  9 19",
                "18  8 23 26 20",
                "22 11 13  6  5",
                "2  0 12  3  7",
                "\n"
        );

        List<String[][]> extractedBingoCards = day4Puzzle1.extractBingoCardsFromInput(input);
        Assertions.assertNotNull(extractedBingoCards);
        Assertions.assertNotEquals(0, extractedBingoCards.size());

        for (String[][] bingoCard : extractedBingoCards)    {
            for (int i = 0; i < bingoCard.length - 1; i++)  {
                for (int j = 0; j < bingoCard[i].length - 1; j++)   {
                    Assertions.assertNotNull(bingoCard[i][j]);
                    Assertions.assertNotEquals("", bingoCard[i][j]);
                }
            }
        }
    }

    @Test
    public void initializeBingoCardsTagsTest() {
        final Day4Puzzle1 day4Puzzle1 = new Day4Puzzle1();
        final List<boolean[][]> initializedBingoCardsTags = day4Puzzle1.initializeBingoCardsTags(5);

        Assertions.assertNotNull(initializedBingoCardsTags);
        Assertions.assertNotEquals(0, initializedBingoCardsTags.size());
        Assertions.assertEquals(5, initializedBingoCardsTags.size());

        for (boolean[][] bingoCardTag : initializedBingoCardsTags)  {
            for (int i = 0; i < bingoCardTag.length - 1; i++)  {
                for (int j = 0; j < bingoCardTag[i].length - 1; j++)   {
                    Assertions.assertFalse(bingoCardTag[i][j]);
                }
            }
        }
    }

    @Test
    public void day4puzzle1SampleTest()     {
        final Day4Puzzle1 day4Puzzle1 = new Day4Puzzle1();
        final List<String> input = Arrays.asList(
                "7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1",
                "\n",
                "22 13 17 11  0",
                "8  2 23  4 24",
                "21  9 14 16  7",
                "6 10  3 18  5",
                "1 12 20 15 19",
                "\n",
                "3 15  0  2 22",
                "9 18 13 17  5",
                "19  8  7 25 23",
                "20 11 10 24  4",
                "14 21 16 12  6",
                "\n",
                "14 21 17 24  4",
                "10 16 15  9 19",
                "18  8 23 26 20",
                "22 11 13  6  5",
                "2  0 12  3  7",
                "\n"
        );

        final int expectedAnswer = day4Puzzle1.resolve(input);
        Assertions.assertEquals(4512, expectedAnswer);
    }
}

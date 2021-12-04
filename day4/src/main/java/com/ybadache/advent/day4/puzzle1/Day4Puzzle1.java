package com.ybadache.advent.day4.puzzle1;

import com.ybadache.advent.commons.utils.ObjectCheckingUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day4Puzzle1 {

    private final static int BINGO_CARD_SIZE = 5;
    public int resolve(List<String> input)      {
        if (ObjectCheckingUtils.isListNullOrEmpty(input) )     {
            return 0;
        }

        final List<String> inputCopy = new ArrayList<>();
        inputCopy.addAll(input);

        // The first line contains all the inputs for the bingo cards
        List<String> bingoDraws = Arrays.asList(inputCopy.get(0).split(","));
        inputCopy.remove(0);
        // The second line is a chariot and we don't need it to fill our arrays
        inputCopy.remove(0);


        List<int[][]> allBingoCards = this.extractBingoCardsFromInput(inputCopy);
        List<boolean[][]> allBingoCardTags = this.initializeBingoCardsTags(allBingoCards.size());

        for (String draw : bingoDraws)     {
            this.doesBingoCardContainsNumber(Integer.parseInt(draw), allBingoCards, allBingoCardTags);
            int winningBoardIndex = this.hasABoardWon(allBingoCardTags);
            if (winningBoardIndex > 0)     {
                return Integer.parseInt(draw) * this.sumOfAllUnmarkedNumbersOnWinningBoard(
                        allBingoCards.get(winningBoardIndex),
                        allBingoCardTags.get(winningBoardIndex));
            }
        }
        return 0;
    }

    public List<int[][]> extractBingoCardsFromInput(List<String> input)  {
        int lineIndex = 0;
        List<int[][]> allBingoCards = new ArrayList<>();


        // We know that a bingo card is 5 x 5
        int[][] bingoCard = new int[BINGO_CARD_SIZE][BINGO_CARD_SIZE];
        for (String line : input)   {
            if (lineIndex == 5)  {
                lineIndex = 0;
                allBingoCards.add(bingoCard.clone());
                bingoCard = new int[BINGO_CARD_SIZE][BINGO_CARD_SIZE];
            } else {
                String[] bingoLine = line.split("\\s+");
                String[] sanitizedBingoLine = Arrays.stream(bingoLine).filter(x -> !StringUtils.isBlank(x)).toArray(String[]::new);
                for (int i = 0; i < sanitizedBingoLine.length; i++)  {
                    bingoCard[lineIndex][i] = Integer.parseInt(sanitizedBingoLine[i]);
                }

                lineIndex++;
            }
        }

        return allBingoCards;
    }

    public List<boolean[][]> initializeBingoCardsTags(int numberOfBingos)   {
        List<boolean[][]> allBingoCardsTags = new ArrayList<>();
        for (int i = 0; i < numberOfBingos; i++)     {
            final boolean[][] bingoCardTags = new boolean[BINGO_CARD_SIZE][BINGO_CARD_SIZE];
            allBingoCardsTags.add(bingoCardTags.clone());
        }

        return allBingoCardsTags;
    }

    public void doesBingoCardContainsNumber(int number, List<int[][]> bingoCards, List<boolean[][]> bingoCardsTags)  {
        int bingoCardIndex = 0;
        for (int[][] bingoCard : bingoCards)    {
            for (int i = 0; i < bingoCard.length; i++)      {
                for (int j = 0; j < bingoCard[i].length; j++)   {
                    if (bingoCard[i][j] == number)  {
                        bingoCardsTags.get(bingoCardIndex)[i][j] = true;
                    }
                }
            }

            bingoCardIndex++;
        }
    }

    public int hasABoardWon(List<boolean[][]> bingoCardsTags)   {
        int bingoCardTagIndex = 0;
        for (boolean[][] bingoCardTags : bingoCardsTags)    {
            // Line index for each bingo card
            for (int i = 0; i < bingoCardTags.length; i++)      {
                int finalIndex = i;
                if (BooleanUtils.and(bingoCardTags[i]))     {
                    return bingoCardTagIndex;
                }

                // column index for each bingo card
                boolean[] column = new boolean[BINGO_CARD_SIZE];
                for (int j = 0; j < bingoCardTags[i].length; j++)    {
                    int finalJndex = j;
                    column[j] = bingoCardTags[i][j];
                }

                if (BooleanUtils.and(column))   {
                    return bingoCardTagIndex;
                }
            }

            bingoCardTagIndex++;
        }

        return -1;
    }

    public int sumOfAllUnmarkedNumbersOnWinningBoard(int[][] winningBingoCard, boolean[][] winningBingoCardTags)     {
        int unmarkedNumbersSum = 0;
        for (int i = 0; i < winningBingoCard.length; i++)   {
            for (int j = 0; j < winningBingoCard[i].length; j++)    {
                if (winningBingoCardTags[i][j] == false)    {
                    unmarkedNumbersSum += winningBingoCard[i][j];
                }
            }
        }

        return unmarkedNumbersSum;
    }
}

package com.ybadache.advent.day4.puzzle1;

import com.ybadache.advent.commons.utils.ObjectCheckingUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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


        List<String[][]> allBingoCards = this.extractBingoCardsFromInput(inputCopy);
        List<boolean[][]> allBingoCardTags = this.initializeBingoCardsTags(allBingoCards.size());

        return 0;
    }

    public List<String[][]> extractBingoCardsFromInput(List<String> input)  {
        int lineIndex = 0;
        List<String[][]> allBingoCards = new ArrayList<>();


        // We know that a bingo card is 5 x 5
        String[][] bingoCard = new String[BINGO_CARD_SIZE][BINGO_CARD_SIZE];
        for (String line : input)   {
            if ("\n".equals(line))  {
                lineIndex = 0;
                allBingoCards.add(bingoCard.clone());
                bingoCard = new String[BINGO_CARD_SIZE][BINGO_CARD_SIZE];
            } else {
                String[] bingoLine = line.split("\\s+");
                for (int i = 0; i < bingoLine.length; i++)  {
                    bingoCard[lineIndex][i] = bingoLine[i];
                }

                lineIndex++;
            }
        }

        return allBingoCards;
    }

    public List<boolean[][]> initializeBingoCardsTags(int numberOfBingos)   {
        List<boolean[][]> allBingoCardsTags = new ArrayList<>();
        for (int i = 0; i < numberOfBingos; i++)     {
            final boolean[][] bingoCardTags = new boolean[][]{};
            allBingoCardsTags.add(bingoCardTags.clone());
        }

        return allBingoCardsTags;
    }
}

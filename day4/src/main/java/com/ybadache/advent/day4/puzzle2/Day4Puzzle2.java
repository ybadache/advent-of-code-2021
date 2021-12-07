package com.ybadache.advent.day4.puzzle2;

import com.ybadache.advent.day4.puzzle1.Day4Puzzle1;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class Day4Puzzle2 {

    private final static int BINGO_CARD_SIZE = 5;

    private final static Map<Integer, int[][]> BINGO_CARDS_MAP = new HashMap<>();
    private final static Map<Integer, boolean[][]> BINGO_CARDS_TAGS_MAP = new HashMap<>();

    public int resolve(List<String> input)      {
        final List<String> inputCopy = new ArrayList<>();
        inputCopy.addAll(input);

        // The first line contains all the inputs for the bingo cards
        List<String> bingoDraws = Arrays.asList(inputCopy.get(0).split(","));
        inputCopy.remove(0);
        // The second line is a chariot and we don't need it to fill our arrays
        inputCopy.remove(0);

        this.extractBingoCardsFromInput(inputCopy);

        return this.findLastWinningBingoCard(bingoDraws);
    }

    private int findLastWinningBingoCard(List<String> bingoDraws) {
        for (String draw : bingoDraws) {
            this.doesBingoCardContainsNumber(Integer.parseInt(draw));

            if (BINGO_CARDS_MAP.size() == 1)  {
                int lastWinningBoardIndex = 0;
                Optional<Integer> lastWinningBoardIndexOptional = BINGO_CARDS_MAP.keySet().stream().findFirst();
                if (lastWinningBoardIndexOptional.isPresent()) {
                    lastWinningBoardIndex = lastWinningBoardIndexOptional.get();
                }
                return Integer.parseInt(draw) * new Day4Puzzle1()
                        .sumOfAllUnmarkedNumbersOnWinningBoard(
                                BINGO_CARDS_MAP.get(lastWinningBoardIndex),
                                BINGO_CARDS_TAGS_MAP.get(lastWinningBoardIndex));
            }

            List<Integer> winningBoardsIndex = this.hasABoardWon();
            if (winningBoardsIndex.size() > 0) {
                for (Integer boardIndex : winningBoardsIndex)   {
                    BINGO_CARDS_MAP.remove(boardIndex);
                    BINGO_CARDS_TAGS_MAP.remove(boardIndex);
                }
            }
        }

        return 0;
    }

    public void extractBingoCardsFromInput(List<String> input)  {
        int lineIndex = 0;

        int bingoCardIndex = 0;

        int[][] bingoCard = new int[BINGO_CARD_SIZE][BINGO_CARD_SIZE];
        for (String line : input)   {
            if (lineIndex == 5)  {
                lineIndex = 0;
                BINGO_CARDS_MAP.put(bingoCardIndex, bingoCard.clone());
                BINGO_CARDS_TAGS_MAP.put(bingoCardIndex, new boolean[BINGO_CARD_SIZE][BINGO_CARD_SIZE]);
                bingoCardIndex++;
                bingoCard = new int[BINGO_CARD_SIZE][BINGO_CARD_SIZE];
            } else {
                String[] sanitizedBingoLine = Arrays.stream(line.split("\\s+"))
                        .filter(x -> !StringUtils.isBlank(x))
                        .toArray(String[]::new);
                for (int i = 0; i < sanitizedBingoLine.length; i++)  {
                    bingoCard[lineIndex][i] = Integer.parseInt(sanitizedBingoLine[i]);
                }

                lineIndex++;
            }
        }
    }

    public void doesBingoCardContainsNumber(int number)  {
        for (Map.Entry<Integer, int[][]> bingoCards : BINGO_CARDS_MAP.entrySet())       {
            boolean found = false;
            int[][] bingoCard = bingoCards.getValue();
            for (int i = 0; i < bingoCard.length; i++)      {
                if (found)  {
                    break;
                }

                for (int j = 0; j < bingoCard[i].length; j++)   {
                    if (bingoCard[i][j] == number)  {
                        BINGO_CARDS_TAGS_MAP.get(bingoCards.getKey())[i][j] = true;
                        found = true;
                        break;
                    }
                }
            }
        }
    }

    public List<Integer> hasABoardWon()   {
        final List<Integer> wonBoards = new ArrayList<>();
        for (Map.Entry<Integer, boolean[][]> bingoCardsTags : BINGO_CARDS_TAGS_MAP.entrySet())     {
            boolean[][] bingoCardTag = bingoCardsTags.getValue();

            for (int i = 0; i < bingoCardTag.length; i++)      {
                int finalIndex = i;
                if (BooleanUtils.and(bingoCardTag[i]))     {
                    wonBoards.add(bingoCardsTags.getKey());
                }

                // column index for each bingo card
                boolean[] column = new boolean[BINGO_CARD_SIZE];
                for (int j = 0; j < bingoCardTag[i].length; j++)    {
                    column[j] = bingoCardTag[i][j];
                }

                if (BooleanUtils.and(column))   {
                    wonBoards.add(bingoCardsTags.getKey());
                }
            }
        }

        return wonBoards;
    }
}

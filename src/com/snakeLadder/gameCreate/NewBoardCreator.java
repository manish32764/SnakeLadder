package com.snakeLadder.gameCreate;

import com.snakeLadder.snakeLadder.SnakeLadderType;
import com.snakeLadder.snakeLadder.SnakeOrLadder;
import com.snakeLadder.structure.Board;
import com.snakeLadder.structure.Colour;
import com.snakeLadder.structure.Square;

import java.util.*;

public class NewBoardCreator {

    public static final int MAX_SQUARE_COUNT = 100;
    public static final int TOTAL_SNAKE_LADDER_COUNT = 10;

    public Board newBoard(){
        Square[] squares = new Square[MAX_SQUARE_COUNT];
        for(int i = 0; i < MAX_SQUARE_COUNT; ++i){
            int displayNumber = i + 1;
            Colour squareColour = getColour(i);

            squares[i] = new Square(displayNumber, squareColour, Optional.empty());
        }
        Board board = new Board(squares);
        List<SnakeOrLadder> snakeLadderConfiguration = createSnakeOrLadderConfiguration(board);
        for(Square square : squares){
            Optional<SnakeOrLadder> snakeOrLadder = getSnakeOrLadder(snakeLadderConfiguration, square.getDisplayNumber());
            square.setSnakeOrLadder(snakeOrLadder);
        }
        return board;
    }

    private List<SnakeOrLadder> createSnakeOrLadderConfiguration(Board board){
        List<SnakeOrLadder> acceptedSnakeOrLadders = new ArrayList<>();
        Random randomNumberGenerator = new Random();
        Random randomSnakeOrLadderGenerator = new Random();

        while(acceptedSnakeOrLadders.size() < TOTAL_SNAKE_LADDER_COUNT){
            SnakeLadderType snakeLadderType = randomSnakeOrLadderGenerator.nextInt(2) == 0 ? SnakeLadderType.SNAKE : SnakeLadderType.LADDER;

            Integer newStartingPosition =  1+ randomNumberGenerator.nextInt(98);
            Integer newEndingPosition = 1 + randomNumberGenerator.nextInt(98);

            int minimumNumber = Math.min(newStartingPosition, newEndingPosition);
            int maximumNumber = Math.max(newStartingPosition, newEndingPosition);

            if(snakeLadderType == SnakeLadderType.SNAKE){
                newStartingPosition = maximumNumber;
                newEndingPosition = minimumNumber;
            }else{
                newStartingPosition = minimumNumber;
                newEndingPosition = maximumNumber;
            }
            SnakeOrLadder newSnakeOrLadder = new SnakeOrLadder(board.getSquareHavingDisplayNumber(newStartingPosition),
                                                               board.getSquareHavingDisplayNumber(newEndingPosition), snakeLadderType);

            if(isSnakeOnVacantPosition(newSnakeOrLadder, acceptedSnakeOrLadders)){
                acceptedSnakeOrLadders.add(newSnakeOrLadder);
            }
        }
        return acceptedSnakeOrLadders;
    }

    private static Optional<SnakeOrLadder> getSnakeOrLadder(List<SnakeOrLadder> acceptedSnakeOrLadders, int squareDisplayNumber) {
        for(SnakeOrLadder snakeOrLadder : acceptedSnakeOrLadders){
            if(snakeOrLadder.getStartingSquare().getDisplayNumber() == squareDisplayNumber){
                return Optional.of(snakeOrLadder);
            }
        }
        return Optional.empty();
    }

    private static boolean isSnakeOnVacantPosition(SnakeOrLadder newSnakeOrLadder, List<SnakeOrLadder> acceptedSnakeOrLadders) {
        for(SnakeOrLadder acceptedSnakeOrLadder : acceptedSnakeOrLadders){
            Set<Integer> preOccupiedPositions = new HashSet<>();
            preOccupiedPositions.add(acceptedSnakeOrLadder.getStartingSquare().getDisplayNumber());
            preOccupiedPositions.add(acceptedSnakeOrLadder.getEndingSquare().getDisplayNumber());

            if(preOccupiedPositions.contains(newSnakeOrLadder.getStartingSquare()) || preOccupiedPositions.contains(newSnakeOrLadder.getEndingSquare())){
                return false;
            }
        }
        return true;
    }

    private static Colour getColour(int squareNumber) {
        int remainder = squareNumber % Colour.values().length;
        return Colour.getColourAtOrdinal(remainder);
    }
}

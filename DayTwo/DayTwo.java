package DayTwo;

import java.util.ArrayList;

public class DayTwo {

    /**
     * @param args
     */
    public static void main (String[] args) {        
        PuzzleReader puzzleReader = new PuzzleReader();
        ArrayList<Round> puzzlePart1 = puzzleReader.LoadPuzzle("DayTwo/puzzleDemoDayTwo.txt", false);

        Integer totalPointsPartOne = ResolveDayTwoPartOne(puzzlePart1);

        System.out.println(String.format("Solution to part 1 is %d", totalPointsPartOne));

        ArrayList<Round> puzzlePart2 = puzzleReader.LoadPuzzle("DayTwo/puzzleDemoDayTwo.txt", true);

        Integer totalPointsPartTwo = ResolveDayTwoPartTwo(puzzlePart2);

        System.out.println(String.format("Solution to part 2 is %d", totalPointsPartTwo));
        
    }

    private static Integer ResolveDayTwoPartTwo(ArrayList<Round> puzzle) {
        int totalPoints = 0;

        for (int i = 0; i < puzzle.size(); i++) 
        {
            totalPoints += puzzle.get(i).CalculatePoints(true);
        }

        return totalPoints;
    }

    private static Integer ResolveDayTwoPartOne(ArrayList<Round> puzzle) {
        int totalPoints = 0;

        for (int i = 0; i < puzzle.size(); i++) 
        {
            totalPoints += puzzle.get(i).CalculatePoints();
        }

        return totalPoints;
    }
    
}

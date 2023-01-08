package DayEight;

public class DayEight {
    /**
     * @param args
     */
    public static void main (String[] args) 
    {
        PuzzleReader puzzleReader = new PuzzleReader();
        int [][] puzzle = puzzleReader.LoadPuzzle("DayEight/puzzleDemoDayEight.txt");

        int total = DayEightPartOneSolution(puzzle);

        System.out.println(String.format("Solution to part 1 is %d", total));

        total =DayEightPartTwoSolution(puzzle);

        System.out.println(String.format("Solution to part 2 is %d", total));
    }

    private static int DayEightPartOneSolution(int[][] puzzle) {
        int total = 0;
        for (int column = 0; column < puzzle[0].length ; column++)
        {
            for (int row =  0; row < puzzle.length ; row++)
            {
                if (IsVisible(puzzle, row, column))
                {
                    total++;
                }
                
            }
        }
        return total;
    }

    public static Boolean IsVisible(int [][] puzzle, int row, int column)
    {
        Boolean visible = true;
        int currentRow = row;

        if ( row == 0 || row == puzzle.length-1 )
        {
            return true;
        }

        if (column == 0 || column == puzzle[0].length -1)
        {
            return true;
        }

        currentRow = row -1;
        while (visible && currentRow >= 0)
        {
            if (puzzle[currentRow][column] >=  puzzle[row][column])
            {
                visible = false;
                break;
            }
            currentRow--;            
        }
        if (visible)
        {
            return true;
        }
        visible = true;
        currentRow = row+1;
        while (visible && currentRow < puzzle.length)
        {
            if (puzzle[currentRow][column] >=  puzzle[row][column])
            {
                visible = false;
                break;
            }
            currentRow++;            
        }
        if (visible)
        {
            return true;
        }
        visible = true;
        int currentColumn = column +1;
        while (visible && currentColumn < puzzle[0].length)
        {
            if (puzzle[row][currentColumn] >=  puzzle[row][column])
            {
                visible = false;
                break;
            }
            currentColumn++;            
        }
        if (visible)
        {
            return true;
        }
        visible = true;
        currentColumn = column -1;
        while (visible && currentColumn >=0)
        {
            if (puzzle[row][currentColumn] >=  puzzle[row][column])
            {
                visible = false;
                break;
            }
            currentColumn--;            
        }
        if (visible)
        {
            return true;
        }

        return false;
    }

    private static int DayEightPartTwoSolution(int[][] puzzle) {
        int maximum  = 0;
        int visibleTrees = 0;
        for (int column = 0; column < puzzle[0].length ; column++)
        {
            for (int row =  0; row < puzzle.length ; row++)
            {
                visibleTrees = CountVisibleTrees(puzzle, row, column);
                if (visibleTrees >= maximum)
                {
                    maximum = visibleTrees;
                }
                
            }
        }
        return maximum;
    }

    private static int CountVisibleTrees(int[][] puzzle, int row, int column) {
        Boolean visible = true;
        int currentRow = row;
        int distanceUp = 0, distanceDown = 0, distanceLeft = 0, distanceRight = 0;

        if ( row == 0 || row == puzzle.length-1 )
        {
            return 0;
        }

        if (column == 0 || column == puzzle[0].length -1)
        {
            return 0;
        }

        currentRow = row -1;
        while (visible && currentRow >= 0)
        {
            distanceUp++;
            if (puzzle[currentRow][column] >=  puzzle[row][column])
            {
                visible = false;
                break;
            }
            currentRow--;            
        }
        
        visible = true;
        currentRow = row+1;
        while (visible && currentRow < puzzle.length)
        {
            distanceDown++;
            if (puzzle[currentRow][column] >=  puzzle[row][column])
            {
                visible = false;
                break;
            }
            
            currentRow++;            
        }
        
        visible = true;
        int currentColumn = column +1;
        while (visible && currentColumn < puzzle[0].length)
        {
            distanceRight++;
            if (puzzle[row][currentColumn] >=  puzzle[row][column])
            {
                visible = false;
                break;
            }
            currentColumn++;            
        }
        
        visible = true;
        currentColumn = column -1;
        while (visible && currentColumn >=0)
        {
            distanceLeft++;
            if (puzzle[row][currentColumn] >=  puzzle[row][column])
            {
                visible = false;
                break;
            }
            currentColumn--;            
        }
        
        return distanceUp * distanceDown * distanceLeft * distanceRight;
    }
}

package DayFour;

import java.util.ArrayList;

public class DayFour {
    /**
     * @param args
     */
    public static void main (String[] args) {        
        PuzzleReader puzzleReader = new PuzzleReader();
        ArrayList<Pair> puzzle = puzzleReader.LoadPuzzle("DayFour/puzzleDemoDayFour.txt");

        int totalContained = 0;
        for (int i = 0; i < puzzle.size(); i++)
        {
            if (IsContained(puzzle.get(i)))
            {
                totalContained ++;
            }
        }

        System.out.println(String.format("Solution for part 1 is %d", totalContained));

        int totalOverlap = 0;
        for (int i = 0; i < puzzle.size(); i++)
        {
            if (IsOverlap(puzzle.get(i)))
            {
                totalOverlap ++;
            }
        }

        System.out.println(String.format("Solution for part 2 is %d", totalOverlap));
        
    }

    public static Boolean IsContained(Pair p)
    {
        //Contained the first in the second
        if ( p.GetPair1().GetMin()>=p.GetPair2().GetMin() && p.GetPair1().GetMax()<= p.GetPair2().GetMax() )
        {
            return true;
        }

        //Contained the second in the second
        if ( p.GetPair2().GetMin()>=p.GetPair1().GetMin() && p.GetPair2().GetMax()<= p.GetPair1().GetMax() )
        {
            return true;
        }

        return false;
    }

    public static Boolean IsOverlap(Pair p)
    {
        if (IsContained(p))
        {
            return true;
        }
        
        if ( p.GetPair1().GetMin()>=p.GetPair2().GetMin() && p.GetPair1().GetMin()<= p.GetPair2().GetMax() )
        {
            return true;
        }

        if ( p.GetPair1().GetMax()>=p.GetPair2().GetMin() && p.GetPair1().GetMax()<= p.GetPair2().GetMax() )
        {
            return true;
        }

        return false;
    }
}

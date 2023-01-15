package DayNine;

import java.util.ArrayList;

public class DayNine {
    /**
     * @param args
     */
    public static void main (String[] args) 
    {
        PuzzleReader puzzleReader = new PuzzleReader();
        ArrayList<Movement> puzzle = null;
        try
        {
            puzzle = puzzleReader.LoadPuzzle("DayNine/puzzleDayNine.txt");
        }
        catch (Exception e)
        {
            System.out.println(String.format("The file provided is not valid. Reaso: %s", e.getMessage()));
        }

        Knot head = new Knot(true);
        Knot tail = new Knot(false);
        
        for (Movement m: puzzle)
        {
            for (int i=0; i< m.GetSteps(); i++)
            {
                try
                {
                    head.MoveOne(m.GetMovement());
                    tail.FollowHead(head);
                }
                catch (Exception e)
                {
                    System.out.println("Movement is not allowed, please check code");
                }
                
            }
        }
        System.out.println(String.format("Solution to part 1 is %d", tail.GetTotalVisited()));

        ArrayList<Knot> knots = new ArrayList<Knot>();
        for (int i=0; i <10; i++)
        {
            if (i == 0)
            {
                knots.add(new Knot(true));
            }
            else
            {
                knots.add(new Knot(false));
            }
        }

        for (Movement m: puzzle)
        {
            for (int i=0; i< m.GetSteps(); i++)
            {
                try
                {
                    knots.get(0).MoveOne(m.GetMovement());
                    for (int j = 1; j < 10; j++)
                    {
                        knots.get(j).FollowHead(knots.get(j-1));
                    }
                }
                catch (Exception e)
                {
                    System.out.println("Movement is not allowed, please check code");
                }
                
            }
        }
        System.out.println(String.format("Solution to part 2 is %d", knots.get(9).GetTotalVisited()));
    }
}

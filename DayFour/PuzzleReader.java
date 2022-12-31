package DayFour;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class PuzzleReader {
    public PuzzleReader() {
        super();
    }

    public ArrayList<Pair> LoadPuzzle(String path)
    {
        ArrayList<Pair> puzzle = new ArrayList<Pair>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String currentLine = "";
            currentLine = reader.readLine();
            while (currentLine != null)
            {

               Pair pair = ParsePairs(currentLine);

               puzzle.add(pair);

               currentLine = reader.readLine();
            }            
            reader.close();
        }
        catch(Exception e)
        {
            return null;
        }
        
        return puzzle;
    }

    private Pair ParsePairs(String currentLine) throws Exception {
        
        String[] intervals = currentLine.split(",");

        if (intervals.length != 2)
        {
            throw new Exception();
        }

        String [] tokensInterval1 = intervals[0].split("-");
        if (tokensInterval1.length != 2)
        {
            throw new Exception();
        }
        int minInterval1 = Integer.parseInt(tokensInterval1[0]);
        int maxInterval1 = Integer.parseInt(tokensInterval1[1]);

        String [] tokensInterval2 = intervals[1].split("-");
        if (tokensInterval2.length != 2)
        {
            throw new Exception();
        }
        int minInterval2 = Integer.parseInt(tokensInterval2[0]);
        int maxInterval2 = Integer.parseInt(tokensInterval2[1]);

        Pair p = new Pair(new Interval(minInterval1, maxInterval1), new Interval(minInterval2, maxInterval2));
        
        return p;
    }
    
}

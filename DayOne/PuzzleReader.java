package DayOne;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class PuzzleReader {
    
    public PuzzleReader() {
        super();
    }

    public ArrayList<Integer> LoadPuzzle(String path)
    {
        ArrayList<Integer> puzzle = new ArrayList<Integer>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String currentLine = "";
            int integerValue = 0;
            while (currentLine != null)
            {
               currentLine = reader.readLine();
               try
               {
                if ("".equals(currentLine))
                {
                    integerValue  = -1;
                }                    
                else
                {
                    integerValue = Integer.parseInt(currentLine);
                }
                
               }               
               catch (NumberFormatException nfe)
               {
                continue;
               }
               puzzle.add(integerValue);
            }            
            reader.close();
        }
        catch(Exception e)
        {
            return null;
        }
        

        return puzzle;
    }
}

package DayNine;

import java.util.ArrayList;

import DayNine.Movement.MOVEMENT_TYPE;

import java.io.BufferedReader;
import java.io.FileReader;

public class PuzzleReader {
    public PuzzleReader() 
    {
        super();
    }

    public ArrayList<Movement> LoadPuzzle(String path)
    {     
        ArrayList<Movement> puzzle = new ArrayList<Movement>();   
        try{
            BufferedReader reader = new BufferedReader(new FileReader(path));            
            String currentLine = reader.readLine();
            while (currentLine != null || currentLine == "")
            {               
                Movement m = ParseLine(currentLine);
                puzzle.add(m);
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

    private Movement ParseLine(String line) throws Exception {
        
        String[] tokens = line.split(" ", 0);

        if (tokens.length != 2)
        {
            throw new Exception("File not valid");
        }

        try
        {
            MOVEMENT_TYPE movement = MOVEMENT_TYPE.valueOf(tokens[0]);
            int steps = Integer.parseInt(tokens[1]);
            Movement m = new Movement(movement, steps);
            return m;
        }
        catch (Exception e)
        {
            throw e;
        }
    }
}

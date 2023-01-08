package DayEight;

import java.io.BufferedReader;
import java.io.FileReader;

public class PuzzleReader {
    public PuzzleReader() {
        super();
    }

    public int[][] LoadPuzzle(String path)
    {     
        int[][] puzzle = null;   
        try{
            BufferedReader reader = new BufferedReader(new FileReader(path));            
            String currentLine = "";
            currentLine = reader.readLine();
            int rows = 0;
            int columns = 0;
            while (currentLine != null || currentLine == "")
            {               
               columns = currentLine.length();
               rows++;
               currentLine = reader.readLine();
            }            
            reader.close();
            reader = new BufferedReader(new FileReader(path)); 

            currentLine = reader.readLine();
            puzzle = new int[rows][columns];
            int currentRow = 0;
            while (currentLine != null || currentLine == "")
            {               
               int[] row = ParseLine(currentLine, columns);
               puzzle[currentRow] = row;
               currentLine = reader.readLine();
               currentRow++;
            }



        }
        catch(Exception e)
        {
            return null;
        }
        
        return puzzle;
    }

    private int[] ParseLine(String currentLine, int columns) {

        int[] row = new int[columns];

        char[] charArrayLine = currentLine.toCharArray();
        int i = 0;
        for ( char c : charArrayLine)
        {            
            row[i] = Integer.parseInt(String.valueOf(c));
            i++;
        }

        return row;
    }

}

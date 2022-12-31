package DayTwo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class PuzzleReader {
    public PuzzleReader() {
        super();
    }

    public ArrayList<Round> LoadPuzzle(String path)
    {
        ArrayList<Round> puzzle = new ArrayList<Round>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String currentLine = "";
            currentLine = reader.readLine();
            while (currentLine != null)
            {

               Round round = ParseRound(currentLine);
               
               puzzle.add(round);

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

    public ArrayList<Round> LoadPuzzle(String path, Boolean partTwo)
    {
        ArrayList<Round> puzzle = new ArrayList<Round>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String currentLine = "";
            currentLine = reader.readLine();
            while (currentLine != null)
            {

               Round round = ParseRound(currentLine, partTwo);
               
               puzzle.add(round);

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

    private Round ParseRound(String currentLine) {

        char opponentMove = currentLine.charAt(0);

        char myMove = currentLine.charAt(2);

        Round round = new Round(opponentMove, myMove);

        return round;
    }

    private Round ParseRound(String currentLine, Boolean partTwo) {

        char opponentMove = currentLine.charAt(0);

        char myMove = currentLine.charAt(2);

        Round round = new Round(opponentMove, myMove, partTwo);

        return round;
    }
}

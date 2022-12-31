package DayThree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class PuzzleReader {
    public PuzzleReader() {
        super();
    }

    public ArrayList<Racksack> LoadPuzzle(String path)
    {
        ArrayList<Racksack> puzzle = new ArrayList<Racksack>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String currentLine = "";
            currentLine = reader.readLine();
            while (currentLine != null)
            {

               Racksack racksack = ParseRacksack(currentLine);

               racksack.FindDuplicatedElement();
               
               puzzle.add(racksack);

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

    private Racksack ParseRacksack(String currentLine) {
        String compartment1 = currentLine.substring(0, (currentLine.length()/2));
        String compartment2 = currentLine.substring((currentLine.length()/2), currentLine.length());

        return new Racksack(currentLine, compartment1, compartment2);
    }
}

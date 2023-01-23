package DayTen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class PuzzleReader {
    public PuzzleReader() {
        super();
    }

    public ArrayList<Command> LoadPuzzle(String path)
    {
        ArrayList<Command> commands = new ArrayList<Command>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String currentLine = "";
            currentLine = reader.readLine();
            while (currentLine != null || currentLine == "")
            {

                Command c = ParseLine(currentLine);

                commands.add(c);

                currentLine = reader.readLine();
            }            
            reader.close();
        }
        catch(Exception e)
        {
            return null;
        }
        
        return commands;
    }

    private Command ParseLine(String currentLine) {

        //Comando
        String[] tokens = currentLine.split(" ");
        if (tokens.length == 1)
        {
            return new Command(tokens[0], null);
        }
        else
        {
            Integer arg = Integer.valueOf(tokens[1]);
            return new Command(tokens[0], arg);
        }

    }
}

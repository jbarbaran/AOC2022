package DaySeven;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import DaySeven.Command.CommandType;
import DaySeven.InformationLine.ObjectType;

public class PuzzleReader {
    public PuzzleReader() {
        super();
    }

    public ArrayList<CommandLine> LoadPuzzle(String path)
    {
        ArrayList<CommandLine> commands = new ArrayList<CommandLine>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String currentLine = "";
            currentLine = reader.readLine();
            while (currentLine != null || currentLine == "")
            {

                CommandLine c = ParseLine(currentLine);

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

    private CommandLine ParseLine(String currentLine) {

        if (currentLine.startsWith("$"))
        {
            //Comando
            String[] tokens = currentLine.split(" ");
            String command = tokens[1];
            CommandLine c;
            if (command.equals("ls"))
            {
                c = new Command(CommandType.ls, null);
            }
            else
            {
                c = new Command(CommandType.cd, tokens[2]);
            }       
            
            return c;
        }
        else
        {
            String[] tokens = currentLine.split(" ");            
            InformationLine c;
            if (tokens[0].equals("dir"))
            {
                c = new InformationLine(ObjectType.Folder, tokens[1],  null);
            }
            else{
                int size = Integer.parseInt(tokens[0]);
                c = new InformationLine(ObjectType.File, tokens[1], size);
            }      
            return c;      
        }

    }
}

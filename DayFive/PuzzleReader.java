package DayFive;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class PuzzleReader {
    public PuzzleReader() {
        super();
    }

    public HashMap<Integer, Stack<String>> LoadPuzzle(String path)
    {
        HashMap<Integer, Stack<String>> puzzle = new HashMap<Integer, Stack<String>>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String currentLine = "";
            currentLine = reader.readLine();
            while (currentLine != null || currentLine == "")
            {

               ParseLine(currentLine, puzzle);

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

    private void ParseLine(String currentLine, HashMap<Integer, Stack<String>> puzzle) {

        char[] charArray = currentLine.toCharArray();

        int i = 0;
        int index = i*4+1;
        while (index < charArray.length)
        {
            if (charArray[index -1 ] == '[')
            {
                char item = charArray[index];
                if (!puzzle.containsKey(i+1))
                {
                    puzzle.put(i+1, new Stack<String>());
                }
                puzzle.get(i+1).push(String.valueOf(item));
            }
            i++;
            index = i*4+1;
        }

    }

    public ArrayList<Command> LoadCommands(String path) {
        ArrayList<Command> commands = new ArrayList<Command>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String currentLine = "";
            currentLine = reader.readLine();
            //Skip the stacks
            while (!"".equals(currentLine))
            {               

               currentLine = reader.readLine();
            }

            currentLine = reader.readLine();
            while (currentLine != null || currentLine == "")
            {

               Command c = ParseCommandLine(currentLine);
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

    private Command ParseCommandLine(String currentLine) {
        String[] tokens = currentLine.split(" ");

        Integer amount = Integer.parseInt(tokens[1]);
        Integer from = Integer.parseInt(tokens[3]);
        Integer to = Integer.parseInt(tokens[5]);

        return new Command(from, to, amount);
    }
}

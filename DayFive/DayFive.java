package DayFive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;

public class DayFive {
    /**
     * @param args
     */
    public static void main (String[] args) {        
        PuzzleReader puzzleReader = new PuzzleReader();
        HashMap<Integer,Stack<String>> stacks = puzzleReader.LoadPuzzle("DayFive/puzzleDemoDayFive.txt");

        for (Stack<String> s: stacks.values())
        {
            Collections.reverse(s);
        }

        ArrayList<Command> commands = puzzleReader.LoadCommands("DayFive/puzzleDemoDayFive.txt");

        for (int i = 0; i < commands.size(); i++)
        {
            RunCommandPart1(stacks, commands.get(i));
        }

        String totalString = "";
        for (Stack<String> s : stacks.values())
        {
            totalString += s.pop();
        }

        System.out.println(String.format("Solution to part 1 is %s", totalString));

        stacks = puzzleReader.LoadPuzzle("DayFive/puzzleDemoDayFive.txt");

        for (Stack<String> s: stacks.values())
        {
            Collections.reverse(s);
        }

        commands = puzzleReader.LoadCommands("DayFive/puzzleDemoDayFive.txt");

        for (int i = 0; i < commands.size(); i++)
        {
            RunCommandPart2(stacks, commands.get(i));
        }

        totalString = "";
        for (Stack<String> s : stacks.values())
        {
            totalString += s.pop();
        }

        System.out.println(String.format("Solution to part 2 is %s", totalString));
        
    }

    private static void RunCommandPart1(HashMap<Integer, Stack<String>> stacks, Command command) {
        Stack<String> fromStack = stacks.get(command.getFrom());
        Stack<String> toStack = stacks.get(command.getTo());

        for (int i = 0; i < command.getAmount(); i++)
        {
            String s = fromStack.pop();
            toStack.push(s);
        }
    }

    private static void RunCommandPart2(HashMap<Integer, Stack<String>> stacks, Command command) {
        Stack<String> fromStack = stacks.get(command.getFrom());
        Stack<String> toStack = stacks.get(command.getTo());
        ArrayList<String> auxList = new ArrayList<String>();

        for (int i = 0; i <= command.getAmount()-1; i++)
        {
            String s = fromStack.pop();
            auxList.add(s);
        }

        if (auxList.size() == 0)
            return;
        for (int i = auxList.size()-1; i >= 0 ; i --)
        {
            toStack.push(auxList.get(i));
        }
    }


}

package DayThree;

import java.util.ArrayList;

public class DayThree {
    /**
     * @param args
     */
    public static void main (String[] args) {        
        PuzzleReader puzzleReader = new PuzzleReader();
        ArrayList<Racksack> puzzle = puzzleReader.LoadPuzzle("DayThree/puzzleDemoDayThree.txt");

        int totalPriority = 0;
        for (int i = 0; i < puzzle.size(); i++)
        {
            totalPriority += GetPriority(puzzle.get(i).GetDuplicatedItem());
        }

        System.out.println(String.format("Solution to part 1 is %d", totalPriority));

        int totalPrioritiesPartTwo = CalculateSumOfDuplicatesInGroupsOfThree(puzzle);
        
        System.out.println(String.format("Solution to part 2 is %d", totalPrioritiesPartTwo));
    }

    private static int CalculateSumOfDuplicatesInGroupsOfThree(ArrayList<Racksack> rackpacks)
    {
        int total = 0;
        for (int i = 0; i < rackpacks.size(); i+=3)
        {
            try
            {
                total+= GetPriority(GetDuplicatedItemOfThree(rackpacks, i));
            }
            catch(Exception e)
            {
                return -1;
            }
            
        }

        return total;
    }

    private static char GetDuplicatedItemOfThree(ArrayList<Racksack> rackpacks, int i) throws Exception 
    {
        if ( i + 2 > rackpacks.size())
        {
            throw new Exception();
        }
        char[] rs1 = rackpacks.get(i).GetRacksack();
        char[] rs2 = rackpacks.get(i+1).GetRacksack();
        char[] rs3 = rackpacks.get(i+2).GetRacksack();

        Boolean found = false;

        char item = '0';

        for (int ix = 0; ix < rs1.length; ix++)
        {
            item = rs1[ix];
            for (int j = 0; j < rs2.length; j++)
            {
                if ( item == rs2[j])
                {
                    for (int z = 0; z < rs3.length; z++)
                    {
                        if (item == rs3[z])
                        {
                            found = true;
                            break;
                        }
                    }
                    if (found)
                    {
                        break;
                    }
                }
            }
            if (found)
            {
                break;
            }
        }

        if (found)
        {
            return item; 
        }
        else
        {
            throw new Exception();
        }
    }

    private static int GetPriority(char item) {
        if ( Character.isLowerCase(item))
        {
            return item - (int)'a' +1;
        }
        else
        {
            return item - (int)'A' +1 +26;
        }
    }
}

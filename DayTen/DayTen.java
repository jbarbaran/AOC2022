package DayTen;

import java.util.ArrayList;

import DayTen.Command.OperationType;

public class DayTen {
    /**
     * @param args
     */
    public static void main (String[] args) 
    {
        PuzzleReader puzzleReader = new PuzzleReader();
        ArrayList<Command> puzzle = puzzleReader.LoadPuzzle("DayTen/puzzleDemoDayTen.txt");

        int[] cycles = {20,60, 100, 140, 180, 220};
        int total = 0;

        int indexArrayCycles = 0;
        int iCycle = 1;
        int iCommand = 0;   
        int register = 1;
        int iCountAdd = 0;

        while ( iCommand < puzzle.size() && indexArrayCycles < cycles.length)
        {
            if ( cycles[indexArrayCycles] == iCycle)
            {
                int tempValue = register * cycles[indexArrayCycles];
                total += tempValue;
                indexArrayCycles++;
                System.out.println(String.format("Cycle: %d Register: %d Value: %d Command: %d", iCycle, register, tempValue, iCommand));
            }

            if (puzzle.get(iCommand).getOperation() == OperationType.noop)
            {
                iCommand++;
                
            }
            else{
                
                iCountAdd ++;
                if (iCountAdd == 2)
                {
                    register += puzzle.get(iCommand).getArgument();
                    iCountAdd = 0;
                    iCommand++;
                }
            }
            iCycle++;
        }

        System.out.println(String.format("Solution for part 1 is: %d", total));

        indexArrayCycles = 0;
        iCycle = 1;
        iCommand = 0;   
        register = 1;
        iCountAdd = 0;

        Boolean[][] crt = new Boolean[40][6];
        int i = 0;
        int j = 0;
        while ( iCommand < puzzle.size())
        {
            if ( i == register || i == register+1 || i == register-1 )
            {
                crt[i][j] = true;
            }
            else
            {
                crt[i][j] = false;
            }

            if (i == 39)
            {
                j++;
                i = 0;
            }
            else{
                i++;
            }

            if (puzzle.get(iCommand).getOperation() == OperationType.noop)
            {
                iCommand++;
                
            }
            else{
                
                iCountAdd ++;
                if (iCountAdd == 2)
                {
                    register += puzzle.get(iCommand).getArgument();
                    iCountAdd = 0;
                    iCommand++;
                }
            }
            iCycle++;
        }

        PrintCrt(crt);
    }

    private static void PrintCrt(Boolean[][] crt) {
        System.out.println("Solution for part 2 is:");
        for (int j = 0; j < crt[0].length; j++)
        {
            for (int i = 0 ; i < crt.length; i++)
            {
                if (crt[i][j] == true)
                {
                    System.out.print("#");
                }
                else
                {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
}

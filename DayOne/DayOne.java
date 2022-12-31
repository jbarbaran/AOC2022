package DayOne;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DayOne {
    /**
     * @param args
     */
    public static void main (String[] args) {
        PuzzleReader puzzleReader = new PuzzleReader();
        ArrayList<Integer> puzzle = puzzleReader.LoadPuzzle("DayOne/puzzleDemoDayOne.txt");

        Integer totalCalories = ResolveDayOnePartOne(puzzle);

        System.out.println(String.format("Solution to part 1 is %d", totalCalories));

        Integer maxCalories = ResolveDayOnePartTwo(puzzle);

        System.out.println(String.format("Solution to part 2 is %d", maxCalories));
        
    }

    private static Integer ResolveDayOnePartOne(ArrayList<Integer> puzzle) {
        
        ArrayList<Elf> elfs = new ArrayList<>();

        Elf elf = new Elf();

        for (int i=0; i< puzzle.size()-1; i++)
        {            
            if (puzzle.get(i) == -1)
            {
                elfs.add(elf);
                elf = new Elf();
                continue;
            }
            elf.addCalories(puzzle.get(i));
        }

        Integer maxCalories = 0;
        for (int i=0; i< elfs.size()-1; i++)
        {   

            if ( maxCalories < elfs.get(i).getTotalCalories() )
            {
                maxCalories = elfs.get(i).getTotalCalories();
            }
        }

        return maxCalories;

    }

    private static Integer ResolveDayOnePartTwo(ArrayList<Integer> puzzle) {
        
        ArrayList<Elf> elfs = new ArrayList<>();

        Elf elf = new Elf();

        for (int i=0; i< puzzle.size()-1; i++)
        {            
            if (puzzle.get(i) == -1)
            {
                elfs.add(elf);
                elf = new Elf();
                continue;
            }
            elf.addCalories(puzzle.get(i));
        }

        List<Elf> sortedElfs = elfs.stream().sorted(Comparator.comparing(Elf::getTotalCalories).reversed()).collect(Collectors.toList());

        return sortedElfs.get(0).getTotalCalories() + sortedElfs.get(1).getTotalCalories() + sortedElfs.get(2).getTotalCalories();

    }
}
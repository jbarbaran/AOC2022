package DaySix;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DaySix {

    // Part 1
    //public static final int CHARS = 4;
    // Part 2
    public static final int CHARS = 14;

    /**
     * @param args
     */
    public static void main (String[] args) 
    {
        String currentLine = "";
        try (BufferedReader reader = new BufferedReader(new FileReader("DaySix/puzzleDemoDaySix.txt"))) {            
            currentLine = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Boolean found = false;
        int i = 0;
        while (!found && i +CHARS < currentLine.length())
        {
            String subString = currentLine.substring(i, i+CHARS);

            if ( !AnyCharacterIsRepeted(subString.toCharArray()) ) 
            {
                found = true;
                break;
            }
            i++;
        }

        System.out.println(i+CHARS);
    }

    private static boolean AnyCharacterIsRepeted(char[] charArray) {
        
        for (int i = 0; i < charArray.length; i ++)
        {
            for (int j = 0; j <charArray.length; j++)
            {
                if ( i == j)
                {
                    continue;
                }

                if (charArray[i] == charArray[j])
                {
                    return true;
                }
            }
        }

        return false;

    }
}

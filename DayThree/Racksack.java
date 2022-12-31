package DayThree;

public class Racksack {

    private char[] compartment1;
    private char[] compartment2;
    private char[] racksack;

    private char duplicatedItem;

    public Racksack(String racksack, String compartment1, String compartment2) {
        super();
        this.racksack = racksack.toCharArray();
        this.compartment1 = compartment1.toCharArray();
        this.compartment2 = compartment2.toCharArray();
    }

    public char[] GetRacksack()
    {
        return racksack;
    }

    public char GetDuplicatedItem()
    {
        return duplicatedItem;
    }

    public char FindDuplicatedElement()
    {
        Boolean found = false;
        int j = 0;
        for (int i = 0; i < compartment1.length; i++)
        {
            for (j = 0; j < compartment2.length; j++)
            {
                if (compartment1[i] == compartment2[j])
                {
                    duplicatedItem = compartment1[i];
                    found = true;
                    
                    break;
                }
            }
            if (found)
            {
                break;
            }
        }

        if (found)
        {
            return duplicatedItem;
        }
        else
        {
            return '-';
        }
    }
}

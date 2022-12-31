package DayOne;

public class Elf implements Comparable{
    private Integer calories;

    public Elf() {
        super();
        calories = 0;
    }

    public void addCalories(int calories)
    {
        this.calories += calories;
    }

    public Integer getTotalCalories()
    {
        return calories;
    }

    @Override
    public int compareTo(Object o) {
        Elf anotherElf = (Elf) o;
    
        return this.getTotalCalories().compareTo(anotherElf.getTotalCalories());
    }
}

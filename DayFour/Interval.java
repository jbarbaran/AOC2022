package DayFour;

public class Interval {

    private int min;
    private int max; 

    public Interval(int min, int max) {
        super();
        this.min = min;
        this.max = max;
    }

    public int GetMax()
    {
        return max;        
    }

    public int GetMin()
    {
        return min;
    }
}

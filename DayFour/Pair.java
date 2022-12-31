package DayFour;

public class Pair {

    private Interval pair1;
    private Interval pair2;

    public Pair(Interval pair1, Interval pair2) {
        super();
        this.pair1 = pair1;
        this.pair2 = pair2;
    }

    public Interval GetPair1(){
        return pair1;
    }

    public Interval GetPair2(){
        return pair2;
    }
}

package DayFive;

public class Command {
    private int from;
    public int getFrom() {
        return from;
    }

    private int to;
    public int getTo() {
        return to;
    }

    private int amount;

    public int getAmount() {
        return amount;
    }

    public Command(int from, int to, int amount) {
        super();
        this.amount = amount;
        this.to = to;
        this.from = from;
    }

    
}

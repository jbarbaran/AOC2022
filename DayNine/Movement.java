package DayNine;

public class Movement {
    public enum MOVEMENT_TYPE {R, U, L, D}

    private final MOVEMENT_TYPE movement;

    private final int steps;

    public Movement(MOVEMENT_TYPE movement, int steps) {
        super();
        this.movement = movement;
        this.steps = steps;
    }

    public MOVEMENT_TYPE GetMovement()
    {
        return movement;
    }

    public int GetSteps()
    {
        return steps;
    }
}

package DayTen;

public class Command {
    public enum OperationType {noop, addx}
    private OperationType operation;
    private Integer argument;

    public Command(String operation, Integer argument) {
        super();
        this.operation = OperationType.valueOf(operation);
        this.argument = argument;
    }

    public OperationType getOperation()
    {
        return operation;
    }

    public Integer getArgument()
    {
        return argument;
    }
}

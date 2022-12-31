package DaySeven;

public class Command extends  CommandLine {

    public enum CommandType { cd, ls}

    private CommandType commandType;
    private String argument;

    public Command(CommandType commandType, String argument) {
        super();
        this.commandType = commandType;
        this.argument = argument;
    }
    
    public CommandType GetCommandType()
    {
        return commandType;
    }

    public String GetArgument()
    {
        return argument;
    }
}

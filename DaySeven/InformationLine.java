package DaySeven;

public class InformationLine extends CommandLine {

    public enum ObjectType { Folder, File };

    private ObjectType object;

    private String name;

    private Integer size;

    public InformationLine( ObjectType type, String name, Integer size) {
        super();
        this.object = type;
        this.name = name;
        this.size = size;        
    }

    public ObjectType GetObjectType()
    {
        return object;        
    }

    public Integer GetSize()
    {
        return size;
    }

    public String GetName()
    {
        return name;
    }
    
}

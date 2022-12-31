package DaySeven;

public class File {
    private String name;
    private Integer size;

    public File() {
        super();
    }

    public File(String name, Integer size)
    {
        this.name = name;
        this.size = size;
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

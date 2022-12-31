package DaySeven;

import java.util.ArrayList;

public class Folder {
    
    private ArrayList<File> files;
    private ArrayList<Folder> subFolders;
    private Folder parentFolder;
    private String name;

    public Folder(String name) {
        super();
        parentFolder = null;
        this.name = name;
        subFolders = new ArrayList<Folder>();
        files = new ArrayList<File>();
    }

    public Folder GetParent()
    {
        return parentFolder;
    }

    public String GetName()
    {
        return name;
    }

    public ArrayList<Folder> Subfolders()
    {
        return subFolders;
    }

    public void addFile(File file)
    {
        files.add(file);
    }

    public void addFolder(Folder folder)
    {
        subFolders.add(folder);
        folder.parentFolder = this;
    }

    public Integer CalculateSizeOfFiles() {
        Integer filesSize = 0;
        for (int i = 0; i < files.size(); i++)
        {
            filesSize += files.get(i).GetSize();
        }

        return filesSize;
    }
}

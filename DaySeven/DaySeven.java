package DaySeven;

import java.util.ArrayList;
import java.util.Collections;

import DaySeven.Command.CommandType;
import DaySeven.InformationLine.ObjectType;

public class DaySeven {
    /**
     * @param args
     */
    public static void main (String[] args) {        
        PuzzleReader puzzleReader = new PuzzleReader();
        ArrayList<CommandLine> commands = puzzleReader.LoadPuzzle("DaySeven/puzzleDemoDaySeven.txt");

        Folder currentFolder = null;
        Folder parent = null;
        //Execute the commands
        for (int i = 0 ; i < commands.size(); i++)
        {
            CommandLine c = commands.get(i);
            if (c instanceof Command)
            {
                CommandType commandType = ((Command)c).GetCommandType();  
                if (commandType == commandType.cd && currentFolder == null)              
                {
                    //Create Folder
                    currentFolder = new Folder(((Command)c).GetArgument()); 
                    parent = currentFolder;                   
                }
                else if (commandType == commandType.cd && currentFolder != null) 
                {
                    if ( ((Command)c).GetArgument().equals(".."))
                    {
                        currentFolder = currentFolder.GetParent();
                    }
                    else if (((Command)c).GetArgument().equals("/"))
                    {
                        Folder f = new Folder(((Command)c).GetArgument());
                        currentFolder.addFolder(f);
                        currentFolder = f;
                        parent = f;
                    }
                    else
                    {
                        for (int j =0; j < currentFolder.Subfolders().size(); j++)
                        {
                            if ( ((Command)c).GetArgument().equals(currentFolder.Subfolders().get(j).GetName()))
                            {
                                currentFolder = currentFolder.Subfolders().get(j);
    
                                break;
                            }
                        }
                        
                    }
                }
                else if (commandType == commandType.ls)
                {
                    continue;
                }
            }
            else if (c instanceof InformationLine)
            {
                ObjectType oType = ((InformationLine)c).GetObjectType();
                if (oType.equals(ObjectType.File))
                {
                    File f = new File( ((InformationLine)c).GetName(), ((InformationLine)c).GetSize() );
                    currentFolder.addFile(f);
                }
                else if (oType.equals(ObjectType.Folder))
                {
                    Folder f = new Folder(((InformationLine)c).GetName());
                    currentFolder.addFolder(f);
                }
            }
        }

        //Calculate total size

        int resPart1 = GetTotalSizeSmallFoldersPart1(parent);

        System.out.println(String.format("Solution to part 1 is %d", resPart1)); 
        
        ArrayList<Integer> sizes = new ArrayList<Integer>();
        GetTotalSizeSmallFoldersPart2(parent, sizes);
        Collections.sort(sizes);

        int parentSize = GetTotalSize(parent);
        int currentlyUnsued = 70000000 - parentSize;
        
        int total = 0;
        int i = 0;
        Boolean found = false;
        while (i < sizes.size() && !found)
        {
            if ( currentlyUnsued + sizes.get(i) > 30000000)             
            {
                found = true;
                total = sizes.get(i);
            }
            i++;
        }

        System.out.println(String.format("Solution to part 2 is %d", total)); 
    }

    public static int GetTotalSizeSmallFoldersPart1(Folder f)
    {
        int total = 0;

        int totalFolder = GetTotalSize(f);
        if (totalFolder <100000)
        {
             total += totalFolder;
        }

        for (Folder sf: f.Subfolders())
        {
            total += GetTotalSizeSmallFoldersPart1(sf);
            //if (totalFolder <100000)
            // {
            //     total += totalFolder;
            // }
            // total+= GetTotalSizeSmallFolders(sf);
        }

        return total;
    }

    public static int GetTotalSizeSmallFoldersPart2(Folder f, ArrayList<Integer> sizes)
    {
        int total = 0;

        int totalFolder = GetTotalSize(f);
        if ( totalFolder != 0 )
            sizes.add(totalFolder);        

        for (Folder sf: f.Subfolders())
        {
            total += GetTotalSizeSmallFoldersPart2(sf, sizes);
            if ( total != 0 )
                sizes.add(total);

        }

        return total;
    }

    public static int GetTotalSize(Folder f)
    {
        int total = 0;
        total += f.CalculateSizeOfFiles();
        for (Folder sf: f.Subfolders())
        {
            total += GetTotalSize(sf);
        }

        return total;
    }
}

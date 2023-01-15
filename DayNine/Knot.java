package DayNine;

import java.util.ArrayList;

import DayNine.Movement.MOVEMENT_TYPE;

public class Knot {
    
    private int currentRow;
    private int currentColumn;

    private ArrayList<Point> visited;

    private Boolean isHead;
    
    public Knot(Boolean isHead) {
        super();
        this.isHead = isHead;
        visited = new ArrayList<Point>();
        visited.add(new Point(0,0));
    }

    public void MoveOne(MOVEMENT_TYPE movement) throws Exception
    {
        if (!isHead)
        {
            throw new Exception("This is not a head knot!");
        }

        switch (movement)
        {
            case L:
            //TODO: What happens if it is negative?
            currentColumn--;
            break;
            case R:
            currentColumn++;
            break;
            case U:
            currentRow--;
            break;
            case D:
            currentRow++;
            break;
        }
        
    }

    public void FollowHead(Knot head)
    {
        if (currentColumn == head.currentColumn)
        {
            if (currentRow > head.currentRow && currentRow - head.currentRow >1)
            {
                currentRow--;
            }
            else if (currentRow < head.currentRow && head.currentRow - currentRow >1)
            {
                currentRow++;
            }
        }
        else if (currentRow == head.currentRow)
        {
            if (currentColumn > head.currentColumn && currentColumn - head.currentColumn >1)
            {
                currentColumn--;
            }
            else if (currentColumn < head.currentColumn && head.currentColumn - currentColumn >1)
            {
                currentColumn++;
            }
        }
        else if (currentColumn != head.currentColumn && currentRow != head.currentRow)
        {
            if (distanceOf( currentRow, currentColumn, head.currentRow, head.currentColumn ) > 2)
            {
                if ( currentColumn > head.currentColumn)
                {
                    currentColumn--;
                }
                else if (currentColumn < head.currentColumn)
                {
                    currentColumn++;
                }

                if (currentRow > head.currentRow)
                {
                    currentRow--;
                }
                else if (currentRow < head.currentRow)
                {
                    currentRow++;
                }
            }
        }
        if ( !visited.contains(new Point(currentRow, currentColumn)))
        {
            visited.add(new Point(currentRow, currentColumn));
        }
        
    }

    private Double distanceOf(int currentRowA, int currentColumnA, int currentRowB, int currentColumnB) {
        Double v = Math.sqrt((currentColumnB - currentColumnA) * (currentColumnB - currentColumnA) + (currentRowB - currentRowA) * (currentRowB - currentRowA));
        return v;
    }

    public int GetTotalVisited()
    {
        return visited.size();
    }

    public int GetRow()
    {
        return currentRow;
    }

    public int GetColumn()
    {
        return currentColumn;
    }
    
}

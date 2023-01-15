package DayNine;

public class Point {
    private int row;
    private int col;

    public Point(int row, int col)
    {
        this.row = row;
        this.col = col;
    }

    public int GetRow()
    {
        return row;
    }

    public int GetCol()
    {
        return col;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Point other = (Point) obj;
        if ((this.col == other.col && this.row == other.row))
        {
            return true;
        }
        return false;
    }
}

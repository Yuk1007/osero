package work;

public class Rectangle
{

    int width;
    int height;

    public Rectangle()
    {
        setSize(0, 0);
    }

    public Rectangle(int width, int height)
    {
        setSize(width, height);
    }

    public void setSize(int width, int height)
    {
        this.width = width;
        this.height = height;
    }
    @Override //@はアノテーション．注釈の一種で目印のようなもの．
    public String toString()
    {
        return "[" + width + ", " + height + "]";
    }
}


class PlacedRectangle
{
    int x;
    Rectangle r;
    int y;
    public PlacedRectangle()
    {
        r = new Rectangle();
        setLocation(0,0);
    }

    public PlacedRectangle(int x,int y)
    {
        r = new Rectangle();
        setLocation(x,y);
    }

    public PlacedRectangle(int x,int y,int width,int height)
    {
        r = new Rectangle(width,height);
        setLocation(x,y);
    }

    public void setLocation(int x,int y)
    {
        this.x = x;
        this.y = y;
    }

    public String toStoring()
    {
        System.out.println("[ (" + x + ", " + y + ") " + r + "]");
        return "[ (" + x + ", " +  y + ") " + r + "]";
    }
}

class Action
{
    public static void main(String[] args)
    {
        PlacedRectangle pr = new PlacedRectangle(12,34,123,45);
        pr.toStoring();
    }
}

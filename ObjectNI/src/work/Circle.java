package work;

public class Circle
{
    private Point2D center;
    private int radius = 0;

    public Circle()
    {
        center = new Point2D();
    }

    public Circle(Point2D c, int radius)
    {
        this.center = c;
        this.radius = radius;
    }

    public Point2D getCenter()
    {
        return center;
    }

    public int getRadius()
    {
        return radius;
    }

    public void setCenter(Point2D c)
    {
        this.center.set(c.getX(),c.getY());
    }

    public void setRadius(int radius)
    {
       this.radius = radius;
    }


    public String toString()
    {
        return "中心座標" + center.toString()+ "半径" + radius;
    }
}

package work;

public class WearableRobot implements Wearable, Colorable
{
    private int color;

    public WearableRobot(int color)
    {
        changeColor(color);
    }

    public void changeColor(int color)
    {
        this.color = color;
    }

    public String toString()
    {
        switch (color)
        {
            case RED:
                return "赤ロボット";
            case GREEN:
                return "緑ロボット";
            case BLUE:
                return "青ロボット";
        }

        return "ロボット";
    }


    public void putOn()
    {
        System.out.println(toString()+"装着!!");
    }


    public void putOff()
    {
        System.out.println(toString()+"解除!!");
    }

}



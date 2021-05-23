package work;

public class Test
{
    public static void main(String[] args)
    {
        Wearable [] w= {
                new WearableComputer("HAL"),
                new WearableRobot(Colorable.RED),
                new WearableRobot(Colorable.GREEN)
        };
        for (Wearable k : w)
        {
            k.putOn();
            k.putOff();
            System.out.println();
        }
    }

}

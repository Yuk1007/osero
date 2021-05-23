package work;

public class ExCarTester1
{
    public static void main(String[] args)
    {
        ExCar myCar = new ExCar("W140", 1885, 1490, 5220, 95.0);
        myCar.putSpec();
        System.out.println("現在位置 : (" + myCar.getX() + ", " + myCar.getY() + ")");
        System.out.println("残り燃料 : " + myCar.getFuel()+ "リットル");
    }
}

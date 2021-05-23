package work;

public class ExCar extends Car
{
    private double totalMileage;
    public ExCar(String name, int width, int height, int length, double fuel)
    {
        super(name, width, height, length, fuel);
        this.totalMileage = 0.0;
    }

    public double getTotalMileage()
    {
        return totalMileage;
    }

    public void putSpec()
    {
        super.putSpec();
        System.out.println("総走行距離 : " + totalMileage + "km");
    }

    @Override
    public boolean move(double dx, double dy)
    {
        double dist = Math.sqrt(dx * dx + dy * dy);
        if(!super.move(dx, dy))
        {
            return false;
        }
        else
        {
            totalMileage += dist;
            return true;
        }
    }
}

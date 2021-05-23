package work;

public class IntTester
{
    private static int compare(int x, int y)
    {
        if (x > y)
        {
            return 1;
        }
        else if (y > x)
        {
            return -1;
        }
        return 0;
    }

    public static void main(String[] args)
    {
        java.util.Scanner stdIn = new java.util.Scanner(System.in);
        Int a = new Int(0);
        Int b = new Int(0);
        System.out.println("a = ");
        a.setV(stdIn.nextInt());
        System.out.println("b = ");
        b.setV(stdIn.nextInt());
        int balance = compare(a.getV(),b.getV());
        if (balance == 1)
        {
            System.out.println("aのほうが大きい");
        }
        else if (balance == -1)
        {
            System.out.println("bのほうが大きい");
        }
        else
        {
            System.out.println("aとbは同じ");
        }
    }
}

package work;

abstract class Calc
{
    abstract int multi(int x);
}

class SubCalc1 extends Calc
{
    int multi(int x)
    {
        return x;
    }
}

class SubCalc2 extends Calc
{
    int multi(int x)
    {
        return x * x;
    }
}

class SubCalc3 extends Calc
{
    int multi(int x)
    {
        return x * x * x;
    }
}


class Main
{
    public static void main(String[] args)
    {
        Calc[] calc = {
                new SubCalc1(),
                new SubCalc2(),
                new SubCalc3()
        };

        for (int i = 0; i < 3; i++)
        {
            System.out.println(calc[i].multi(5));
        }

    }

}
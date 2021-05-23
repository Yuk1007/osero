package work;


public abstract class Animal
{

    private String name;

    Animal(String name)
    {
        this.name = name;
    }

    public abstract void bark();

    public abstract String toString();

    String getName()
    {
        return name;
    }

    public void introduce()
    {
        System.out.print(toString()+ "だ");
        bark();
    }
}

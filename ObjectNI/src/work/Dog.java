package work;


public class Dog extends Animal
{
    private String type;

    Dog(String name, String type)
    {
        super(name);
        this.type = type;
    }


    public void bark()
    {
        System.out.println("ワンワン!!");
    }

    public String toString()
    {
        return type + "の" +getName();
    }
}

package work;

public class Cat extends Animal
{
    private int age;

    Cat(String name, int age)
    {
        super(name);
        this.age = age;

    }

    public void bark()
    {
        System.out.println("ニャン!!");
    }

    public String toString()
    {
        return age + "歳の" + getName();
    }
}

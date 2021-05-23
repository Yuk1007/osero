package work;

public class AnimalTester
{
    public static void main(String[] args)
    {
        Animal a[] = {
                new Dog("タロー", "柴犬"),
                new Cat("マイケル", 7),
                new Dog("ハチ公", "秋田犬")
        };
        for (Animal k : a)
        {
            k.introduce();
        }

    }

}

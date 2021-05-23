package rpg.area;

import rpg.character.hero.Hero;
import rpg.character.hero.HeroParty;

public abstract class Area
{
    protected String name;

    public Area()
    {

    }

    abstract Area access(HeroParty party);

    String getName()
    {
        return this.name;
    }

    abstract void printArea();

    void setName(String name)
    {
        this.name = name;
    }
}

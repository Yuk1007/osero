package rpg.area;

import rpg.character.monster.BabyDragon;
import rpg.character.monster.Dragon;
import rpg.character.monster.KingDemon;
import rpg.character.monster.Monster;

public class Dungeon1st extends Dungeon
{
    public Dungeon1st()
    {
        this.name = "ドラゴンの巣窟";
        this.encountCounter = 0;
        this.floorNum = 1;
    }

    @Override
    protected Area nextArea()
    {
        return new Dungeon2nd();
    }

    @Override
    protected Monster nextBoss()
    {
        return new Dragon();
    }

    @Override
    protected Monster nextMob()
    {
        return new BabyDragon();
    }
}

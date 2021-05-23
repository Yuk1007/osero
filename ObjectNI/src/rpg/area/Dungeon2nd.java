package rpg.area;

import rpg.character.monster.*;

public class Dungeon2nd extends Dungeon
{
    public Dungeon2nd()
    {
        this.name = "デーモンの間";
        this.encountCounter = 0;
        this.floorNum = 2;
    }

    @Override
    protected Area nextArea()
    {
        return new DungeonCREAR();
    }

    @Override
    protected Monster nextBoss()
    {
        return new KingDemon();
    }

    @Override
    protected Monster nextMob()
    {
        return new Demon();
    }
}

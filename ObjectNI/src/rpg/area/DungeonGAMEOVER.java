package rpg.area;

import rpg.character.hero.HeroParty;
import rpg.character.monster.Monster;

public class DungeonGAMEOVER extends Dungeon
{
    @Override
    protected Area nextArea()
    {
        return null;
    }

    @Override
    protected Monster nextBoss()
    {
        return null;
    }

    @Override
    protected Monster nextMob()
    {
        return null;
    }

    public Area access(HeroParty party)
    {
        System.out.println("ゲームオーバー！！");
        System.out.println("また挑戦してね");
        System.exit(0);
        return null;
    }
}

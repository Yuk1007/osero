package rpg.area;

import rpg.character.AbstractCharacter;
import rpg.character.hero.Hero;
import rpg.character.hero.HeroParty;
import rpg.character.monster.Monster;

public class DungeonCREAR extends Dungeon
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
        System.out.println("ゲームクリア！！");
        try
        {
            Thread.sleep(1000);
            System.out.println("Cast");
            Thread.sleep(1000);
            for(AbstractCharacter m:party.getMembers())
            {
                System.out.println("ヒーロー1：" + m.getName() + "(" + ((Hero) m).getJob() + ")");
                Thread.sleep(1000);
            }
            System.out.print("お  ");
            Thread.sleep(1000);
            System.out.print("わ  ");
            Thread.sleep(1000);
            System.out.println("り  ");
            System.exit(0);

        }
        catch (InterruptedException e)
        {
            throw new Error();
        }
        return null;
    }
}

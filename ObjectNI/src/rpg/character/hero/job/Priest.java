package rpg.character.hero.job;

import rpg.ScanCommand;
import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;
import rpg.character.hero.HeroParty;

import java.util.Random;

public class Priest extends AbstractSuperHero
{
    private String job = "僧侶";

    public Priest(String name)
    {
        super(name, 100, 4);
    }

    public String getJob()
    {
        return this.job;
    }

    public boolean special(AbstractParty targets)
    {
        Random random = new Random();
        System.out.println(this.getName() + "のヒール，味方全員が優しい光に包まれた");
        for (AbstractCharacter ally : targets.getMembers())
        {
            if (!ally.isDead() && !ally.isEscaped())
            {
                int randomHeal = random.nextInt(10) + 11;
                int heal = ally.gotHeal(randomHeal);
                System.out.println(ally.getName() + "が" + heal + "の回復");
            }
        }
        return true;
    }

    @Override
    protected void command(AbstractParty allies, AbstractParty enemies)
    {
        System.out.print(getName() + "(" + getJob() + ")の行動:");
        System.out.println("1:戦う　2：逃げる 3:必殺技");
        int command = ScanCommand.scan();
        if (command == 1)
        {// 戦う1

            while (true)
            {
                if (this.attack(enemies))
                {
                    break;
                }
            }
        }
        else if (command == 2)
        {// 逃げる
            this.run();
        }
        else if (command == 3)
        {// 必殺技
            while (true)
            {
                if (this.special(allies))
                {
                    break;
                }
            }
        }
        else
        {
            this.command(allies, enemies);
        }
    }
}

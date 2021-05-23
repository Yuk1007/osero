package rpg.character.hero;

import rpg.ScanCommand;
import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;
import rpg.character.hero.job.AbstractSuperHero;

public class Hero extends AbstractCharacter
{
    protected String job = null;

    public Hero(String name, int hp, int attack)
    {
        super(name, hp, attack);
    }

    @Override
    protected void command(AbstractParty allies, AbstractParty enemies)
    {
        System.out.print(getName() + "(" + job + ")の行動:");
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
//        else if (command == 3)
//        {// 必殺技
//            while (true)
//            {
//                if (this.special(enemies))
//                {
//                    break;
//                }
//            }
//        }
        else
        {
            this.command(allies, enemies);
        }

    }

    public String getJob()
    {
        return this.job;
    }

    public void rest()
    {
        this.gotHeal(getMaxHp());
    }

    public void run()
    {
        System.out.println(getName() + "は逃げ出した");
        this.escaped = true;
    }

    @Override
    protected AbstractCharacter selectTarget(AbstractParty targets)
    {
        System.out.println("対象は");
        int i = 0;
        for (AbstractCharacter target : targets.getMembers())
        {
            if (!target.isDead())
            {
                System.out.println(i + ":" + target.getName() + " ");
            }
            i++;
        }
        System.out.println();
        int targetNo = ScanCommand.scan();
        if (targetNo < targets.getMembers().length)
        {
            if (!targets.getMembers()[targetNo].isDead())
            {
                return targets.getMembers()[targetNo];
            }
            else
            {
                return selectTarget(targets);
            }
        }
        else
        {
            return selectTarget(targets);
        }
    }
}

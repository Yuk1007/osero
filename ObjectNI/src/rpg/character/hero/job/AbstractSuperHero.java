package rpg.character.hero.job;

import rpg.ScanCommand;
import rpg.character.AbstractParty;
import rpg.character.hero.Hero;
import rpg.checkpoints.Specialist;

public class AbstractSuperHero extends Hero implements Specialist
{

    public AbstractSuperHero(String name, int hp, int attack)
    {
        super(name, hp, attack);
    }

    @Override
    public boolean special(AbstractParty targets)
    {
        return false;
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
                if (this.special(enemies))
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

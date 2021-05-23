package rpg.character.hero;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

/**
 * パーティの行動を表現するクラス
 */
public class HeroParty extends AbstractParty
{
    public HeroParty(AbstractCharacter[] heros)
    {
        super(heros);
    }

    @Override
    public boolean isEscapeAll()
    {
        for (AbstractCharacter m : getMembers())
        {
            if (!m.isEscaped())
            {
                return false;
            }
        }
        return true;
    }

    public void rest()
    {
        for (AbstractCharacter m : getMembers())
        {
            m.gotHeal(m.getMaxHp());
        }

    }

    public void printPartyStatus()
    {
        for (AbstractCharacter m : getMembers())
            if (m.getHp() > 0 && !m.isEscaped())
            {
                System.out.print(m.getName() + "(" + ((Hero) m).getJob() + "):" + m.getHp() + " ");
            }
            else if (m.isEscaped())
            {
                System.out.println(m.getName() + "(" + ((Hero) m).getJob() + "):逃亡　");
            }
            else if (m.getHp() <= 0)
            {
                System.out.println(m.getName() + "(" + ((Hero) m).getJob() + "):死亡　");
            }
    }

    public void printPartyStatus(Hero hero)
    {

    }

    public void init()
    {
        for (AbstractCharacter m : getMembers())
        {
            m.init();
        }
    }

}

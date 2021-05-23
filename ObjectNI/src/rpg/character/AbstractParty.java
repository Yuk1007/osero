package rpg.character;

public abstract class AbstractParty
{
    private AbstractCharacter[] members;

    public AbstractParty(AbstractCharacter[] members)
    {
        this.members = members;
    }

    public AbstractCharacter[] getMembers()
    {
        return this.members;
    }

    public boolean isAllDead()
    {
        for (AbstractCharacter m : members)
        {
            if (!m.isDead())
            {
                return false;
            }
        }
        return true;
    }

    protected abstract boolean isEscapeAll();

    public String turn(AbstractParty enemies)
    {
        for (AbstractCharacter m : members)
        {
            if (!m.isDead() && !m.isEscaped())
            {
                m.command(this, enemies);
                if (enemies.isAllDead())
                {
                    return "BEAT";
                }
                if (this.isEscapeAll())
                {
                    return "ESCAPE";
                }
            }
        }


        return "CONTINUE";
    }
}

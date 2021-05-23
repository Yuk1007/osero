package rpg.character.monster;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

public class MonsterParty extends AbstractParty
{
    public MonsterParty(AbstractCharacter[] monsters)
    {
        super(monsters);
    }

    protected boolean isEscapeAll()
    {
        return false;
    }
}

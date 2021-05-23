package rpg.character.hero.job;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

import java.util.Random;

public class Warrior extends AbstractSuperHero
{
    private String job = "戦士";

    public Warrior(String name)
    {
        super(name, 100, 30);
    }

    public String getJob()
    {
        return this.job;
    }

    public boolean special(AbstractParty targets)
    {
        AbstractCharacter targetCharacter = selectTarget(targets);
        if (targetCharacter.isDead())
        {
            return false;
        }
        Random random = new Random();
        int randomAttack = 0;
        int damage;
        if (targetCharacter.getName().equals("RedDragon"))
        {
            randomAttack = random.nextInt(attack) + attack + 30;
            damage = targetCharacter.gotDamage(randomAttack);
        }
        else
        {
            randomAttack = random.nextInt(attack) + attack;
            damage = targetCharacter.gotDamage(randomAttack);
        }
        System.out.println(this.getName() + "のドラゴンキック，" + targetCharacter.getName() + "に" + damage + "のダメージ");
        return true;
    }
}

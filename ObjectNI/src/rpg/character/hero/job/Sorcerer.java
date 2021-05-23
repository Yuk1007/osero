package rpg.character.hero.job;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

import java.util.Random;

public class Sorcerer extends AbstractSuperHero
{
    private String job = "魔法使い";

    public Sorcerer(String name)
    {
        super(name, 100, 15);
    }

    public String getJob()
    {
        return this.job;
    }

    public boolean special(AbstractParty targets)
    {
        Random random = new Random();
        System.out.println(this.getName() + "のファイア，敵全員が炎の渦に巻き込まれた");
        for (AbstractCharacter enemy : targets.getMembers())
        {
            if (!enemy.isDead() && !enemy.isEscaped())
            {
                int randomAttack = random.nextInt(attack) + attack;
                int damage = enemy.gotDamage(randomAttack);
                System.out.println(enemy.getName() + "に" + damage + "のダメージ");
                enemy.actionStatus();
            }
        }
        return true;
    }

}

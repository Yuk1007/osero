package rpg.character.monster;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

import java.util.Random;

public class Dragon extends BossMonster
{
    public Dragon()
    {
        super("RedDragon", 200, 30);
    }

    public boolean special(AbstractParty enemies)
    {
        Random random = new Random();
        System.out.println(this.getName() + "の竜の息吹，勇者たちに全体攻撃");
        for(AbstractCharacter enemy : enemies.getMembers())
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

    protected void command(AbstractParty allies, AbstractParty enemies)
    {
        if (!this.isDead())
        {
            System.out.println(this.getName() + "の行動");
            Random random = new Random();
            int command = random.nextInt(5);
            if (0 <= command && command <= 3)
            {
                while (true)
                {
                    if (attack(enemies))
                    {
                        break;
                    }
                }
            }
            else
            {
                this.special(enemies);
            }
        }
    }
}

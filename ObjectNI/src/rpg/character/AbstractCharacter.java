package rpg.character;

import rpg.character.monster.Monster;

import java.util.Arrays;
import java.util.Random;

public abstract class AbstractCharacter
{
    protected int attack;
    protected boolean escaped;
    private int hp;
    private int maxHp;
    private String name;

    protected AbstractCharacter(String name, int hp, int attack)
    {
        this.maxHp = hp;
        this.hp = maxHp;
        this.name = name;
        this.attack = attack;
    }

    public void actionStatus()
    {
        if (this.isDead())
        {
            System.out.println(name + "は倒れた");
        }
    }

    public boolean attack(AbstractParty enemies)
    {
        AbstractCharacter enemy = this.selectTarget(enemies);
        if (this.isDead() || this.isEscaped())
        {
            return false;
        }
        Random random = new Random();
        int randomAttack = random.nextInt(attack) + attack;
        int damage = enemy.gotDamage(randomAttack);
        System.out.println(name + "の攻撃" + enemy.getName() + "に" + damage + "のダメージ");
        enemy.actionStatus();
        return true;
    }


    protected abstract void command(AbstractParty allies, AbstractParty enemies);

    public int getAttack()
    {
        return this.attack;
    }

    public int getHp()
    {
        return this.hp;
    }

    public int getMaxHp()
    {
        return this.maxHp;
    }

    public String getName()
    {
        return this.name;
    }

    public int gotDamage(int damage)
    {
        if (hp - damage < 0)
        {
            damage = hp;
            hp = 0;
        }
        else
        {
            hp = hp - damage;
        }
        return damage;
    }

    public int gotHeal(int heal)
    {
        if (hp + heal < maxHp)
        {
            hp = hp + heal;
            heal = maxHp - hp;
        }
        else
        {
            hp = maxHp;
        }
        return heal;
    }

    public void init()
    {
        escaped = false;
    }

    public boolean isDead()
    {
        return hp <= 0;
    }

    public boolean isEscaped()
    {
        return escaped;
    }

    protected abstract AbstractCharacter selectTarget(AbstractParty targets);

    private void setAttack(int attack)
    {
        this.attack = attack;
    }

    private void setHp(int hp)
    {
        this.hp = hp;
    }

    private void setMaxHp(int maxHp)
    {
        this.maxHp = maxHp;
    }

    private void setName(String name)
    {
        this.name = name;
    }

}

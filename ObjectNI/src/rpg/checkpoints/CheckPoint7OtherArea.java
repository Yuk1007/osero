package rpg.checkpoints;

import rpg.area.Area;
import rpg.area.Hotel;
import rpg.area.Town;
import rpg.character.AbstractCharacter;
import rpg.character.hero.Hero;
import rpg.character.hero.HeroParty;
import rpg.character.hero.job.Warrior;

public class CheckPoint7OtherArea
{

    public static void main(String[] args)
    {
        // 勇者パーティ作成
        Hero[] heros = {
                new Warrior("a1"),
                new Warrior("a2"),
                new Warrior("a3")
        };
        HeroParty party = new HeroParty(heros);

        // 勇者たちに30ダメージを与える
        for (AbstractCharacter h : party.getMembers())
        {
            h.gotDamage(30);
        }

        // 町でホテルに行ってダメージ回復
        Area area;
        Town town = new Town();
        area = town.access(party);
        if (area instanceof Hotel)
        {
            ((Hotel) area).access(party);
        }

        // 勇者たちが回復していることを確認
        party.printPartyStatus();
    }

}

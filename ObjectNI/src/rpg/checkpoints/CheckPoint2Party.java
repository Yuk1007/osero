package rpg.checkpoints;

import rpg.character.hero.Hero;
import rpg.character.hero.HeroParty;

public class CheckPoint2Party
{

    public static void main(String[] args)
    {
        // 戦士クラスの配列を2つ作成
        Hero hs1[] = {
                new Hero("a1", 100, 30),
                new Hero("a2", 100, 30),
                new Hero("a3", 100, 30)
        };
        Hero hs2[] = {
                new Hero("b1", 100, 30),
                new Hero("b2", 100, 30),
                new Hero("b3", 100, 30)
        };

        // ヒーローパーティを2つ作成
        HeroParty corps1 = new HeroParty(hs1);
        HeroParty corps2 = new HeroParty(hs2);

        // 戦士の部隊同士で戦わせる
        while (!corps1.isAllDead() && !corps2.isAllDead())
        {
            System.out.println("部隊1のターン");
            corps1.printPartyStatus();
            corps1.turn(corps2);
            if (corps1.isEscapeAll())
            {
                break;
            }
            System.out.println("部隊2のターン");
            corps2.printPartyStatus();
            corps2.turn(corps1);
            if (corps2.isEscapeAll())
            {
                break;
            }
        }
    }

}

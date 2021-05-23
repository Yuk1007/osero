package rpg.checkpoints;

import rpg.BattleField;
import rpg.character.hero.Hero;
import rpg.character.hero.HeroParty;
import rpg.character.monster.BabyDragon;
import rpg.character.monster.Monster;
import rpg.character.monster.MonsterParty;

//import rpg.area.*;
//import rpg.character.hero.job.Warrior;
//import rpg.character.monster.monster.BabyDragon;

public class CheckPoint4Battle
{

    public static void main(String[] args)
    {
        // 勇者パーティ作成
        Hero heros[] = {
                new Hero("a1", 100, 30),
                new Hero("a2", 100, 30),
                new Hero("a3", 100, 30)
        };
        HeroParty hpty = new HeroParty(heros);

        // モンスターパーティ作成
        Monster ms[] = {
                new BabyDragon()
        };
        MonsterParty mpty = new MonsterParty(ms);

        // ヒーロパーティーとモンスターパーティの戦闘
        BattleField bf = new BattleField();
        String result = bf.battle(hpty, mpty);
		System.out.println(result);
        if (result.equals("WIN"))
        {
            System.out.println("ヒーローたちは勝利した");
        }
        else if (result.equals("LOSE"))
        {
            System.out.println("ヒーローたちは敗北した");
        }
        else
        {
            System.out.println("ヒーローたちは逃げ出した");
        }
    }

}

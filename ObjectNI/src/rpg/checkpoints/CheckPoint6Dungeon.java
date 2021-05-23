package rpg.checkpoints;

import rpg.area.*;
import rpg.character.hero.Hero;
import rpg.character.hero.HeroParty;
import rpg.character.hero.job.Priest;
import rpg.character.hero.job.Sorcerer;
import rpg.character.hero.job.Warrior;

public class CheckPoint6Dungeon {

	public static void main(String[] args) {
		// 勇者パーティ作成
		Hero[] heros = {
				new Warrior("Yuki"),
				new Sorcerer("Haruto"),
				new Priest("Hiroki")
		};
		HeroParty party = new HeroParty(heros);
		
		// ダンジョン地下1階に行く
		// ビッグマタンゴを倒したら終了
		Dungeon1st dungeon = new Dungeon1st();
		dungeon.access(party);
	}

}

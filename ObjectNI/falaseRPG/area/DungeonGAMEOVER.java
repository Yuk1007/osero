package rpg.area;

import rpg.character.hero.HeroParty;

public class DungeonGAMEOVER {
	public void access(HeroParty party) {
		System.out.println("ゲームオーバー！！");
		System.out.println("また挑戦してね");
		System.exit(0);
	}
}

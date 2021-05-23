package rpg.area;

import rpg.character.hero.HeroParty;


public class DungeonCLEAR {
	public void access(HeroParty party) {
		System.out.println("ゲームクリア！！");
		try {
			Thread.sleep(1000);
			System.out.println("Cast");
			Thread.sleep(1000);
			System.out.println("ヒーロー1：" + party.w.name + "(" + party.w.job + ")");
			Thread.sleep(1000);
			System.out.println("ヒーロー2：" + party.s.name + "(" + party.s.job + ")");
			Thread.sleep(1000);
			System.out.println("ヒーロー1：" + party.p.name + "(" + party.p.job + ")");

			System.out.print("お  ");
			Thread.sleep(1000);
			System.out.print("わ  ");
			Thread.sleep(1000);
			System.out.println("り  ");
			System.exit(0);

		} catch (InterruptedException e) {
			throw new Error();
		}
	}


}

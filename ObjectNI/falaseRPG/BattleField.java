package rpg;


import rpg.character.hero.HeroParty;
import rpg.character.monster.BigMatango;
import rpg.character.monster.Demon;
import rpg.character.monster.Matango;
import rpg.character.monster.MatangoParty;
import rpg.character.monster.DemonParty;
import rpg.character.monster.Dragon;
import rpg.character.monster.KingDemon;

public class BattleField {
	/**
	 * バトルの処理を行うメソッド モンスターをすべて倒す，勇者が逃げ出す，勇者たちが力尽きると処理が終わる．
	 * 
	 * @param monsters
	 * @return 勝利すればtrue,負ければfalseを返す
	 */
	
	/**
	 * マタンゴのパーティとのバトルの処理を行うメソッド
	 * @param heros
	 * @param matangos
	 * @return 勝利すればtrue,負ければfalseを返す
	 */
	public static String battle(HeroParty heros, MatangoParty matangos) {
		heros.init();
		for (Matango m : matangos.matangos) {
			System.out.print(m.name + " ");
		}
		System.out.println("があらわれた");
		while (true) {
			System.out.println("勇者のターン");
			heros.printPartyStatus();
			String flg = heros.turn(matangos);
			if(flg.equals("BEAT")){
				return "WIN";
			}else if(flg.equals("ESCAPE")){
				return "ESCAPE";
			}
			System.out.println("モンスターのターン");
			flg = matangos.turn(heros);
			if(flg.equals("BEAT")){
				return "LOSE";
			}
		}
	}
	
	public static String battle(HeroParty heros, BigMatango bm) {
		heros.init();
		System.out.print(bm.name + "があらわれた");
		while (true) {
			System.out.println("勇者のターン");
			heros.printPartyStatus();
			String flg = heros.turn(bm);
			if(flg.equals("BEAT")){
				return "WIN";
			}else if(flg.equals("ESCAPE")){
				return "ESCAPE";
			}
			System.out.println("モンスターのターン");
			flg = bm.turn(heros);
			if(flg.equals("BEAT")){
				return "LOSE";
			}
		}
	}

	public static String battle(HeroParty heros, DemonParty demons) {
		heros.init();
		for (Demon d : demons.demons) {
			System.out.print(d.name + " ");
		}
		System.out.println("があらわれた");
		while (true) {
			System.out.println("勇者のターン");
			heros.printPartyStatus();
			String flg = heros.turn(demons);
			if(flg.equals("BEAT")){
				return "WIN";
			}else if(flg.equals("ESCAPE")){
				return "ESCAPE";
			}
			System.out.println("モンスターのターン");
			flg = demons.turn(heros);
			if(flg.equals("BEAT")){
				return "LOSE";
			}
		}
	}
	
	public static String battle(HeroParty heros, KingDemon kd) {
		heros.init();
		System.out.print(kd.name + "があらわれた");
		while (true) {
			System.out.println("勇者のターン");
			heros.printPartyStatus();
			String flg = heros.turn(kd);
			if(flg.equals("BEAT")){
				return "WIN";
			}else if(flg.equals("ESCAPE")){
				return "ESCAPE";
			}
			System.out.println("モンスターのターン");
			flg = kd.turn(heros);
			if(flg.equals("BEAT")){
				return "LOSE";
			}
		}
	}

	
	public static String battle(HeroParty heros, Dragon dragon) {
		heros.init();
		System.out.print(dragon.name + "があらわれた");
		while (true) {
			System.out.println("勇者のターン");
			heros.printPartyStatus();
			String flg = heros.turn(dragon);
			if(flg.equals("BEAT")){
				return "WIN";
			}else if(flg.equals("ESCAPE")){
				return "ESCAPE";
			}
			System.out.println("モンスターのターン");
			flg = dragon.turn(heros);
			if(flg.equals("BEAT")){
				return "LOSE";
			}
		}
	}


}

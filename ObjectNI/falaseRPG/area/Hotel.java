package rpg.area;

import rpg.ScanCommand;
import rpg.character.hero.HeroParty;

/**
 * 宿屋のクラス 勇者を回復させる，restメソッド
 * 
 *
 */
public class Hotel {
	String name = "宿屋";

	public void printArea() {
		System.out.println("現在の場所は" + name + "です．");
	}

	public void rest(HeroParty party) {
		party.rest();
	}

	public void access(HeroParty party) {
		this.printArea();
		party.printPartyStatus();
		while (true) {
		System.out.println("どうしますか");
		System.out.println("1:休息する　2:はじまりの町へ戻る");
		int nextMove = ScanCommand.scan();
			if (nextMove == 1) {
				this.rest(party);
			}
			Town town = new Town();
			town.access(party);
		}
	}
}

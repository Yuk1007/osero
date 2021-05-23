package rpg.area;

import rpg.ScanCommand;
import rpg.character.hero.HeroParty;

/**
 * はじまりの町のクラス
 * 
 *
 */
public class Town {
	String name = "はじまりの町";

	public void printArea() {
		System.out.println("現在の場所は" + name + "です．");
	}

	public void access(HeroParty party) {
		this.printArea();
		party.printPartyStatus();
		while (true) {
			System.out.println("どこへ移動しますか");
			System.out.println("1:宿屋　2：ダンジョン");
			int nextMove = ScanCommand.scan();
			if (nextMove == 1) {
				Hotel hotel = new Hotel();
				hotel.access(party);
			} else if (nextMove == 2) {
				Dungeon1st dungeon1st = new Dungeon1st();
				dungeon1st.access(party);
			}
		}
	}

}

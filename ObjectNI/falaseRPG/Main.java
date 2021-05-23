package rpg;


import rpg.area.Town;
import rpg.character.hero.HeroParty;

/**
 * メインクラス
 *
 */
public class Main {

	/**
	 * エリアとパーティの生成，エリア移動，クリア判定を行うメソッド
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Town town = new Town();
		HeroParty party = new HeroParty();
		town.access(party);
		while (true) {
			if(nowArea.equals("はじまりの町") && areaNo==1) {
				Hotel hotel = new Hotel();
				hotel.access(party);
				areaNo = town.access(party);	
			}
			else if(nowArea.equals("はじまりの町") && areaNo==2) {
				Dungeon1st dungeon1 = new Dungeon1st();
				dungeon1.access(party);
				nowArea = "ダンジョン1";
				
			}
			else if(nowArea.equals("ダンジョン1") && areaNo==2) {
				areaNo = town.access(party);
				nowArea = "はじまりの町";				
			}


			area = area.access(party);
			if(area==null){
				break;
			}
		}
	}
}

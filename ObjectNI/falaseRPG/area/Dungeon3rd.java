package rpg.area;

import java.util.Random;

import rpg.BattleField;
import rpg.ScanCommand;
import rpg.character.hero.HeroParty;
import rpg.character.monster.DemonParty;
import rpg.character.monster.Dragon;
import rpg.character.monster.MatangoParty;

public class Dungeon3rd {
		String name = "シス工A棟";
		int floorNum=3;
		int encountCounter;
		
		//まだ
		public void access(HeroParty party) {
			this.printArea();
			party.printPartyStatus();
			while (true) {
				System.out.println("どうしますか");
				System.out.println("1:探索する　2：はじまりの町へ戻る");
				int nextMove = ScanCommand.scan();
				if (nextMove == 1) {
					String result = this.explore(party);
					if (result.equals("WIN")) {
						DungeonCLEAR CLEAR = nextArea();
						CLEAR.access(party);
					} else if (result.equals("LOSE")) {
						DungeonGAMEOVER GAMEOVER =  new DungeonGAMEOVER();
						GAMEOVER.access(party);				
						}
				} else if (nextMove == 2) {
					Town town = new Town();
					town.access(party);
				}
			}
		}
		/**
		 * パーティがダンジョン内の探索を行う モンスターとのエンカウント率を表現している
		 * 
		 * @param party
		 */
		public String explore(HeroParty party) {
			String result;
			while (true) {
				this.printExplore();
				Random random = new Random();
				int randomNum = random.nextInt(5);
				if ((randomNum == 0 && this.encountCounter > 1) || this.encountCounter > 3) {
					result = this.encountBoss(party);
					if(result.equals("ESCAPE")){
						continue;
					}
					return result;
				} else if (1 <= randomNum && randomNum <= 3) {
					result = this.encountMob(party);
					if(result.equals("LOSE")){
						return result;
					}
					this.encountCounter += 1;
				} 
			}
		}
		
		private void printExplore() {
			System.out.println("トコトコ");
			for (int i = 0; i < 3; i++) {
				System.out.print("．");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println();
		}

		private String encountMob(HeroParty party) {
			System.out.println("モンスターと遭遇した");
			Random random = new Random();
			int number = random.nextInt(1) + 1;
			if(number==1) {
				MatangoParty matangos = new MatangoParty();
				String result = BattleField.battle(party, matangos);
				this.printBattleResult(result,"戦い");
				return result;
			}else {				
				DemonParty demons = new DemonParty();
				String result = BattleField.battle(party, demons);
				this.printBattleResult(result,"戦い");
				return result;
			}
		}

		private String encountBoss(HeroParty party) {
			System.out.println("ボスモンスターと遭遇した");
			Dragon dragon = this.nextBoss();
			String result = BattleField.battle(party, dragon);
			this.printBattleResult(result, dragon.name);
			return result;
		}

		private void printBattleResult(String result, String string) {
			if (result.equals("WIN")) {
				System.out.println("勇者たちは"+string+"に勝利した");
			} else if(result.equals("LOSE")){
				System.out.println("勇者たちは"+string+"に敗北した");
			} else if(result.equals("ESCAPE")){
				System.out.println("勇者たちは"+string+"から逃げ出した");
			}		
		}

		
		public void printArea() {
			System.out.println("現在の場所は" + name + "地下" + floorNum + "階です．");
		}	
	
		
	protected Dragon nextBoss() {
		return new Dragon();
	}

	protected DungeonCLEAR nextArea() {
		return new DungeonCLEAR();
	}

}

package rpg.checkpoints;

import rpg.character.AbstractCharacter;
import rpg.character.hero.*;
//import rpg.character.hero.job.Warrior;
import rpg.character.monster.*;
//import rpg.character.monster.monster.*;

public class CheckPoint3Monster {

	public static void main(String[] args) {
		// マタンゴ生成
		Monster matango = new BabyDragon();
		
		// マタンゴのデータを表示
		System.out.println("name: " + matango.getName());
		System.out.println("hp: " + matango.getHp());
		System.out.println("power: " + matango.getAttack());
		
		// モンスターパーティ作成
		Monster ms1[] = {
				new BabyDragon()
		};
		Monster ms2[] = {
				new BabyDragon()
		};
		MonsterParty mpty1 = new MonsterParty(ms1);
		MonsterParty mpty2 = new MonsterParty(ms2);
		
		// モンスター同士で喧嘩
		while(!mpty1.isAllDead() && !mpty2.isAllDead()) {
			System.out.println("モンスターパーティー1のターン");
			mpty1.turn(mpty2);
			System.out.println("モンスターパーティー2のターン");
			mpty2.turn(mpty1);
			if (mpty1.isAllDead()) {
				System.out.println("モンスターパーティー2の勝ち");
			}
			if (mpty2.isAllDead()) {
				System.out.println("モンスターパーティー1の勝ち");
			}
		}
	}

}

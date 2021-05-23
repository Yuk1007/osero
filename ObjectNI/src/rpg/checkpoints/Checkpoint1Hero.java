package rpg.checkpoints;

import rpg.character.hero.Hero;

public class Checkpoint1Hero {

	public static void main(String[] args) {
		// インスタンス生成
		Hero h1 = new Hero("kojiro", 100, 10);

		// 勇者の名前と現在のHPを表示
		System.out.println("名前: " + h1.getName());
		System.out.println("現在のHP: " + h1.getHp());
		System.out.println("ジョブ: " + h1.getJob());
		
		// 勇者に攻撃を与える
		int damage = 30;
		System.out.println(h1.getName() + "に攻撃");
		System.out.println(h1.getName() + "は" + h1.gotDamage(damage) + "ダメージ受けた");
		System.out.println("現在のHP: " + h1.getHp());
		
		// 勇者を休ませる
		System.out.println(h1.getName() + "を休ませた");
		h1.rest();
		System.out.println("現在のHP: " + h1.getHp());
				
		// 勇者が逃げ出した
		h1.run();
		
		// 勇者に致命的なダメージを与える
		damage = 500;
		System.out.println(h1.getName() + "に致命的なダメージを与えた");
		System.out.println(h1.getName() + "は" + h1.gotDamage(damage) + "ダメージ受けた");
		System.out.println("現在のHP: " + h1.getHp());
		h1.actionStatus();
	}

}

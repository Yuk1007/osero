package rpg.character.monster;

import java.util.Random;

import rpg.character.hero.HeroParty;

/**
 * 地下1階のボスモンスター：ビッグマタンゴのクラス 必殺技：ねむりの胞子のメソッド
 * 
 *
 */
public class BigMatango{
	public String name = "ビッグマタンゴ";
	private int hp= 100;
	private int maxHp = 100;
	protected int attack = 5;
	protected boolean escaped = false ;
	
	public boolean isDead() {
		if (hp <= 0) {
			return true;
		}
		return false;
	}
	
	public int getDamage(int damage) {
		if (hp - damage < 0) {
			damage = hp;
			hp =0;
		}else{
			hp = hp - damage;
		}
		return damage;
	}

	public int getHeal(int heal) {
		if (hp + heal < maxHp) {
			hp =hp + heal;
			heal = maxHp - hp;
		} else {
			hp = maxHp;
		}
		return heal;
	}

	public boolean isEscaped() {
		return escaped;
	}

	public void actionStatus() {
		if(this.isDead()){		
			System.out.println(name +"は倒れた");
		}
	}

	
	protected void command(HeroParty enemies) {
		if (!this.isDead()) {
			System.out.println(name + "の行動");
			Random random = new Random();
			int command = random.nextInt(5);
			if (0 <= command && command <= 3) {
				while (true) {
					if (attack(enemies)) {
						break;
					}
				}
			} else if (command == 4) {
				while (true) {
					if (this.special(enemies)) {
						break;
					}
				}
			}
		}
	}
	
	//勇者クラスを変数には扱えないため，番号を返す（0＝戦士，1＝魔法師，2＝僧侶）
	protected int selectTarget(HeroParty targets) {
		Random random = new Random();
		int target = random.nextInt(3);
		return target;
	}

	public boolean attack(HeroParty enemies) {
		int targetCharacterNo = this.selectTarget(enemies);
		if(targetCharacterNo == 0 ) {
			if (enemies.w.isDead()|| enemies.w.isEscaped()) {
				return false;
			}
			Random random = new Random();
			int randomAttack = random.nextInt(attack) + attack;
			int damage = enemies.w.gotDamage(randomAttack);
			System.out.println(name + "の攻撃" + enemies.w.name + "に" + damage + "のダメージ");
			enemies.w.actionStatus();
		}
		else if(targetCharacterNo == 1 ) {
			if (enemies.s.isDead() || enemies.s.isEscaped()) {
				return false;
			}
			Random random = new Random();
			int randomAttack = random.nextInt(attack) + attack;
			int damage = enemies.s.gotDamage(randomAttack);
			System.out.println(name + "の攻撃" + enemies.s.name + "に" + damage + "のダメージ");
			enemies.s.actionStatus();
		}
		else if(targetCharacterNo == 2 ){
			if (enemies.p.isDead() || enemies.p.isEscaped()) {
				return false;
			}
			Random random = new Random();
			int randomAttack = random.nextInt(attack) + attack;
			int damage = enemies.p.gotDamage(randomAttack);
			System.out.println(name + "の攻撃" + enemies.p.name + "に" + damage + "のダメージ");
			enemies.p.actionStatus();
		}
		return true;
	}
	
	public boolean special(HeroParty enemies) {
		Random random = new Random();
		System.out.println(name + "の毒の胞子，勇者たちに全体攻撃");
		if (!enemies.w.isDead() && !enemies.w.isEscaped()) {
			int randomAttack = random.nextInt(attack) + attack;
			int damage = enemies.w.gotDamage(randomAttack);
			System.out.println(enemies.w.name + "に" + damage + "のダメージ");
			enemies.w.actionStatus();
		}
		if (!enemies.s.isDead() && !enemies.s.isEscaped()) {
			int randomAttack = random.nextInt(attack) + attack;
			int damage = enemies.s.gotDamage(randomAttack);
			System.out.println(enemies.s.name + "に" + damage + "のダメージ");
			enemies.s.actionStatus();
		}
		if (!enemies.p.isDead() && !enemies.p.isEscaped()) {
			int randomAttack = random.nextInt(attack) + attack;
			int damage = enemies.p.gotDamage(randomAttack);
			System.out.println(enemies.p.name + "に" + damage + "のダメージ");
			enemies.p.actionStatus();
		}
		return true;
	}
	
	public String turn(HeroParty hero) {
		if (!isDead() && !isEscaped()) {
			if (hero.isAllDead()) {
				return "BEAT";
			}
			if (this.escaped) {
				return "ESCAPE";
			}
		}
		return "CONTINUE";
	}


}

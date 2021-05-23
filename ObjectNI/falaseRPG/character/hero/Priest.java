package rpg.character.hero;

import java.util.Random;

import rpg.ScanCommand;
import rpg.character.monster.BigMatango;
import rpg.character.monster.Demon;
import rpg.character.monster.DemonParty;
import rpg.character.monster.Dragon;
import rpg.character.monster.KingDemon;
import rpg.character.monster.Matango;
import rpg.character.monster.MatangoParty;

/**
 * 僧侶のクラス
 * 必殺技：ヒールを行うメソッド
 *
 */
public class Priest{
	public String name = "三郎";
	public int hp = 100;
	public int maxHp = 100;
	public int attack = 4;
	public boolean escaped = false;
	public String job = "僧侶";

	
	public boolean isDead() {
		if (hp <= 0) {
			return true;
		}
		return false;
	}

	
	public void run() {
		System.out.println(name + "は逃げ出した");
		this.escaped = true;
	}


	public void rest() {
		this.gotHeal(maxHp);
	}

	
	public int gotDamage(int damage) {
		if (hp - damage < 0) {
			damage = hp;
			hp =0;
		}else{
			hp = hp - damage;
		}
		return damage;
	}

	public int gotHeal(int heal) {
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
	
	/**
	 * 勇者のバトルコマンドを選択し，ターゲットを決める． 選択肢の結果がモンスター，勇者のHPなどに反映される．
	 * 
	 * @param hero
	 * @param monsters
	 */
	protected void command(HeroParty allies, MatangoParty enemies) {
		System.out.print(name + "(" + job + ")の行動:");
		System.out.println("1:戦う　2：逃げる　3：必殺技");
		int command = ScanCommand.scan();
		if (command == 1) {// 戦う
			while (true) {
				if (this.attack(enemies)) {
					break;
				}
			}
		} else if (command == 2) {// 逃げる
			this.run();
		} else if (command == 3) {// 必殺技
			while (true) {
				if (this.special(allies)) {
					break;
				}
			}
		} else {
			this.command(allies, enemies);
		}
	}
	
	protected void command(HeroParty allies, DemonParty enemies) {
		System.out.print(name + "(" + job + ")の行動:");
		System.out.println("1:戦う　2：逃げる　3：必殺技");
		int command = ScanCommand.scan();
		if (command == 1) {// 戦う
			while (true) {
				if (this.attack(enemies)) {
					break;
				}
			}
		} else if (command == 2) {// 逃げる
			this.run();
		} else if (command == 3) {// 必殺技
			while (true) {
				if (this.special(allies)) {
					break;
				}
			}
		} else {
			this.command(allies, enemies);
		}
	}

	protected void command(HeroParty allies, BigMatango enemies) {
		System.out.print(name + "(" + job + ")の行動:");
		System.out.println("1:戦う　2：逃げる　3：必殺技");
		int command = ScanCommand.scan();
		if (command == 1) {// 戦う
			while (true) {
				if (this.attack(enemies)) {
					break;
				}
			}
		} else if (command == 2) {// 逃げる
			this.run();
		} else if (command == 3) {// 必殺技
			while (true) {
				if (this.special(allies)) {
					break;
				}
			}
		} else {
			this.command(allies, enemies);
		}
	}
	
	protected void command(HeroParty allies, KingDemon enemies) {
		System.out.print(name + "(" + job + ")の行動:");
		System.out.println("1:戦う　2：逃げる　3：必殺技");
		int command = ScanCommand.scan();
		if (command == 1) {// 戦う
			while (true) {
				if (this.attack(enemies)) {
					break;
				}
			}
		} else if (command == 2) {// 逃げる
			this.run();
		} else if (command == 3) {// 必殺技
			while (true) {
				if (this.special(allies)) {
					break;
				}
			}
		} else {
			this.command(allies, enemies);
		}
	}

	protected void command(HeroParty allies, Dragon enemies) {
		System.out.print(name + "(" + job + ")の行動:");
		System.out.println("1:戦う　2：逃げる　3：必殺技");
		int command = ScanCommand.scan();
		if (command == 1) {// 戦う
			while (true) {
				if (this.attack(enemies)) {
					break;
				}
			}
		} else if (command == 2) {// 逃げる
			this.run();
		} else if (command == 3) {// 必殺技
			while (true) {
				if (this.special(allies)) {
					break;
				}
			}
		} else {
			this.command(allies, enemies);
		}
	}

	
	
	//攻撃する敵を選択するメソッド．デーモンとマタンゴがいるパーティはまだ
	protected Matango selectTarget(MatangoParty targets) {
		System.out.println("対象は");
		int i = 0;
		for (Matango target : targets.matangos) {
			if (!target.isDead()) {
				System.out.println(i + ":" + target.name + " ");
			}
			i++;
		}
		System.out.println();
		int targetNo = ScanCommand.scan();
		if (targetNo < targets.matangos.length) {
			if (!targets.matangos[targetNo].isDead()) {
				return targets.matangos[targetNo];
			} else {
				return selectTarget(targets);
			}
		} else {
			return selectTarget(targets);
		}
	}
	
	protected Demon selectTarget(DemonParty targets) {
		System.out.println("対象は");
		int i = 0;
		for (Demon target : targets.demons) {
			if (!target.isDead()) {
				System.out.println(i + ":" + target.name + " ");
			}
			i++;
		}
		System.out.println();
		int targetNo = ScanCommand.scan();
		if (targetNo < targets.demons.length) {
			if (!targets.demons[targetNo].isDead()) {
				return targets.demons[targetNo];
			} else {
				return selectTarget(targets);
			}
		} else {
			return selectTarget(targets);
		}
	}
	
	protected BigMatango selectTarget(BigMatango target) {
		System.out.println("対象は");
		int i=0;
		if (!target.isDead()) {
			System.out.println(i + ":" + target.name + " ");
		}
		System.out.println();
		int targetNo = ScanCommand.scan();
		if (targetNo == 0) {
			if (!target.isDead()) {
				return target;
			} else {
				return selectTarget(target);
			}
		} else {
			return selectTarget(target);
		}
	}
	
	protected KingDemon selectTarget(KingDemon target) {
		System.out.println("対象は");
		int i=0;
		if (!target.isDead()) {
			System.out.println(i + ":" + target.name + " ");
		}
		System.out.println();
		int targetNo = ScanCommand.scan();
		if (targetNo == 0) {
			if (!target.isDead()) {
				return target;
			} else {
				return selectTarget(target);
			}
		} else {
			return selectTarget(target);
		}
	}
	
	protected Dragon selectTarget(Dragon target) {
		System.out.println("対象は");
		int i=0;
		if (!target.isDead()) {
			System.out.println(i + ":" + target.name + " ");
		}
		System.out.println();
		int targetNo = ScanCommand.scan();
		if (targetNo == 0) {
			if (!target.isDead()) {
				return target;
			} else {
				return selectTarget(target);
			}
		} else {
			return selectTarget(target);
		}
	}

	

	//攻撃するメソッド．デーモンとマタンゴがいるパーティはまだ
	public boolean attack(MatangoParty enemies) {
		Matango targetCharacter = null;
		targetCharacter = this.selectTarget(enemies);
		if (targetCharacter.isDead()) {
			return false;
		}
		Random random = new Random();
		int randomAttack = random.nextInt(attack) + attack;
		int damage = targetCharacter.getDamage(randomAttack);
		System.out.println(name + "の攻撃" + targetCharacter.name + "に" + damage + "のダメージ");
		targetCharacter.actionStatus();
		return true;
	}
	
	public boolean attack(DemonParty enemies) {
		Demon targetCharacter = null;
		targetCharacter = this.selectTarget(enemies);
		if (targetCharacter.isDead()) {
			return false;
		}
		Random random = new Random();
		int randomAttack = random.nextInt(attack) + attack;
		int damage = targetCharacter.getDamage(randomAttack);
		System.out.println(name + "の攻撃" + targetCharacter.name + "に" + damage + "のダメージ");
		targetCharacter.actionStatus();
		return true;
	}

	public boolean attack(BigMatango enemies) {
		if (enemies.isDead()) {
			return false;
		}
		Random random = new Random();
		int randomAttack = random.nextInt(attack) + attack;
		int damage = enemies.getDamage(randomAttack);
		System.out.println(name + "の攻撃" + enemies.name + "に" + damage + "のダメージ");
		enemies.actionStatus();
		return true;
	}
	
	public boolean attack(KingDemon enemies) {
		if (enemies.isDead()) {
			return false;
		}
		Random random = new Random();
		int randomAttack = random.nextInt(attack) + attack;
		int damage = enemies.getDamage(randomAttack);
		System.out.println(name + "の攻撃" + enemies.name + "に" + damage + "のダメージ");
		enemies.actionStatus();
		return true;
	}
	
	public boolean attack(Dragon enemies) {
		if (enemies.isDead()) {
			return false;
		}
		Random random = new Random();
		int randomAttack = random.nextInt(attack) + attack;
		int damage = enemies.getDamage(randomAttack);
		System.out.println(name + "の攻撃" + enemies.name + "に" + damage + "のダメージ");
		enemies.actionStatus();
		return true;
	}
	

	public boolean special(HeroParty targets) {
		Random random = new Random();
		System.out.println(name + "のヒール，味方全員が優しい光に包まれた");
		if(!targets.w.isDead()&&!targets.w.isEscaped()){
			int randomHeal = random.nextInt(10) + 11;
			int heal = targets.w.gotHeal(randomHeal);
			System.out.println(targets.w.name+ "が" + heal + "の回復");
		}
		if(!targets.s.isDead()&&!targets.s.isEscaped()){
			int randomHeal = random.nextInt(10) + 11;
			int heal = targets.s.gotHeal(randomHeal);
			System.out.println(targets.s.name+ "が" + heal + "の回復");
		}
		if(!targets.p.isDead()&&!targets.p.isEscaped()){
			int randomHeal = random.nextInt(10) + 11;
			int heal = targets.p.gotHeal(randomHeal);
			System.out.println(targets.p.name+ "が" + heal + "の回復");
		}

		return true;
	}

	public void init() {
		escaped = false;
	}

}

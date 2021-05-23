package rpg.character.monster;

import java.util.Random;

import rpg.character.hero.HeroParty;

/**
 * デーモンとマタンゴどちらも出現するパーティ
 *
 */
public class MonsterParty {
	Random random = new Random();
	int numOfMatango = random.nextInt(3);
	public Matango[] matangos = getMatango(numOfMatango);
	public Demon[] demons = getDemon(3 - numOfMatango);
	
	public Matango[] getMatango(int numOfMatango) {
		Matango[] matangos = new Matango[numOfMatango];
		for (int i = 0; i < numOfMatango; i++) {
			matangos[i]=new Matango();
			matangos[i].name = matangos[i].name + i;
			
		}
		return matangos;
	}
	
	public Demon[] getDemon(int numOfDemon) {
		Demon[] demons = new Demon[numOfDemon];
		for (int i = 0; i < numOfDemon; i++) {
			demons[i]=new Demon();
			demons[i].name = demons[i].name + i;
		}
		return demons;
	}
	
	
	public boolean isAllDead() {
		for (Matango m : matangos) {
			if(m.isEscaped()){
				continue;
			}else if (!m.isDead()) {
				return false;
			}
		}
		for (Demon d : demons) {
			if(d.isEscaped()){
				continue;
			}else if (!d.isDead()) {
				return false;
			}
		}
		return true;
	}
	
	protected boolean isEscapeAll() {
		return false;
	}
	
	public String turn(HeroParty hero) {
		for (Matango m : matangos) {
			if (!m.isDead() && !m.isEscaped()) {
				if (hero.isAllDead()) {
					return "BEAT";
				}
				if (this.isEscapeAll()) {
					return "ESCAPE";
				}
			}
		}		
		for (Demon d : demons) {
			if (!d.isDead() && !d.isEscaped()) {
				if (hero.isAllDead()) {
					return "BEAT";
				}
				if (this.isEscapeAll()) {
					return "ESCAPE";
				}
			}
		}		

		return "CONTINUE";
	}


}

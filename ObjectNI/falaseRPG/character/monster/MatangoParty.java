package rpg.character.monster;

import java.util.Random;
import rpg.character.hero.HeroParty;

public class MatangoParty {
	public Matango[] matangos = getParty();
	
	public Matango[] getParty() {
		Random random = new Random();
		int numOfMonster = random.nextInt(3) + 1;
		Matango[] matangos = new Matango[numOfMonster];
		for (int i = 0; i < numOfMonster; i++) {
			matangos[i]=new Matango();
			matangos[i].name = matangos[i].name + i;
			
		}
		return matangos;
	}
	
	public boolean isAllDead() {
		for (Matango m : matangos) {
			if(m.isEscaped()){
				continue;
			}else if (!m.isDead()) {
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
		return "CONTINUE";
	}


}

package rpg.character.monster;

import java.util.Random;
import rpg.character.hero.HeroParty;

public class DemonParty {
	public Demon[] demons = getParty();
	
	public Demon[] getParty() {
		Random random = new Random();
		int numOfMonster = random.nextInt(3) + 1;
		Demon[] Demons = new Demon[numOfMonster];
		for (int i = 0; i < numOfMonster; i++) {
			Demons[i]=new Demon();
			Demons[i].name = Demons[i].name + i;
			
		}
		return Demons;
	}
	
	public boolean isAllDead() {
		for (Demon m : demons) {
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
		for (Demon m : demons) {
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

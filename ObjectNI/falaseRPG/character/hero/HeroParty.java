package rpg.character.hero;

import java.util.Random;

import rpg.character.hero.Priest;
import rpg.character.hero.Sorcerer;
import rpg.character.hero.Warrior;
import rpg.character.monster.BigMatango;
import rpg.character.monster.KingDemon;
import rpg.character.monster.Matango;
import rpg.character.monster.MatangoParty;
import rpg.character.monster.DemonParty;
import rpg.character.monster.Dragon;
import rpg.character.monster.MonsterParty;

/**
 * パーティの行動を表現するクラス
 * 
 *
 */
public class HeroParty{
	public Warrior w = new Warrior();
	public Sorcerer s = new Sorcerer();
	public Priest p = new Priest();

	public void rest() {
		w.rest();
		s.rest();
		p.rest();
	}
	
	public boolean isAllDead() {
		if (!w.isDead()) {
			return false;
		}
		if (!s.isDead()) {
			return false;
		}
		if (!p.isDead()) {
			return false;
		}
		return true;
	}

	public String turn(MatangoParty m) {
		for (int i = 0; i<3 ;i++) {
			if(i==0) {
				if (!w.isDead() && !w.isEscaped()) {
					w.command(m);
					if (m.isAllDead()) {
						return "BEAT";
					}
					if (this.isEscapeAll()) {
						return "ESCAPE";
					}
				}
			}
			if(i==1) {
				if (!s.isDead() && !s.isEscaped()) {
					s.command(m);
					if (m.isAllDead()) {
						return "BEAT";
					}
					if (this.isEscapeAll()) {
						return "ESCAPE";
					}
				}
			}
			if(i==2) {
				if (!p.isDead() && !p.isEscaped()) {
					p.command(this, m);
					if (m.isAllDead()) {
						return "BEAT";
					}
					if (this.isEscapeAll()) {
						return "ESCAPE";
					}
				}
			}
		}		
		return "CONTINUE";
	}
	
	public String turn(BigMatango bm) {
		for (int i = 0; i<3 ;i++) {
			if(i==0) {
				if (!w.isDead() && !w.isEscaped()) {
					w.command(bm);
					if (bm.isDead()) {
						return "BEAT";
					}
					if (this.isEscapeAll()) {
						return "ESCAPE";
					}
				}
			}
			if(i==1) {
				if (!s.isDead() && !s.isEscaped()) {
					s.command(bm);
					if (bm.isDead()) {
						return "BEAT";
					}
					if (this.isEscapeAll()) {
						return "ESCAPE";
					}
				}
			}
			if(i==2) {
				if (!p.isDead() && !p.isEscaped()) {
					p.command(this, bm);
					if (bm.isDead()) {
						return "BEAT";
					}
					if (this.isEscapeAll()) {
						return "ESCAPE";
					}
				}
			}
		}		
		return "CONTINUE";
	}

	public String turn(DemonParty d) {
		for (int i = 0; i<3 ;i++) {
			if(i==0) {
				if (!w.isDead() && !w.isEscaped()) {
					w.command(d);
					if (d.isAllDead()) {
						return "BEAT";
					}
					if (this.isEscapeAll()) {
						return "ESCAPE";
					}
				}
			}
			if(i==1) {
				if (!s.isDead() && !s.isEscaped()) {
					s.command(d);
					if (d.isAllDead()) {
						return "BEAT";
					}
					if (this.isEscapeAll()) {
						return "ESCAPE";
					}
				}
			}
			if(i==2) {
				if (!p.isDead() && !p.isEscaped()) {
					p.command(this, d);
					if (d.isAllDead()) {
						return "BEAT";
					}
					if (this.isEscapeAll()) {
						return "ESCAPE";
					}
				}
			}
		}		
		return "CONTINUE";
	}
	
	public String turn(KingDemon kd) {
		for (int i = 0; i<3 ;i++) {
			if(i==0) {
				if (!w.isDead() && !w.isEscaped()) {
					w.command(kd);
					if (kd.isDead()) {
						return "BEAT";
					}
					if (this.isEscapeAll()) {
						return "ESCAPE";
					}
				}
			}
			if(i==1) {
				if (!s.isDead() && !s.isEscaped()) {
					s.command(kd);
					if (kd.isDead()) {
						return "BEAT";
					}
					if (this.isEscapeAll()) {
						return "ESCAPE";
					}
				}
			}
			if(i==2) {
				if (!p.isDead() && !p.isEscaped()) {
					p.command(this, kd);
					if (kd.isDead()) {
						return "BEAT";
					}
					if (this.isEscapeAll()) {
						return "ESCAPE";
					}
				}
			}
		}		
		return "CONTINUE";
	}
	
	
	public String turn(Dragon dragon) {
		for (int i = 0; i<3 ;i++) {
			if(i==0) {
				if (!w.isDead() && !w.isEscaped()) {
					w.command(dragon);
					if (dragon.isDead()) {
						return "BEAT";
					}
					if (this.isEscapeAll()) {
						return "ESCAPE";
					}
				}
			}
			if(i==1) {
				if (!s.isDead() && !s.isEscaped()) {
					s.command(dragon);
					if (dragon.isDead()) {
						return "BEAT";
					}
					if (this.isEscapeAll()) {
						return "ESCAPE";
					}
				}
			}
			if(i==2) {
				if (!p.isDead() && !p.isEscaped()) {
					p.command(this, dragon);
					if (dragon.isDead()) {
						return "BEAT";
					}
					if (this.isEscapeAll()) {
						return "ESCAPE";
					}
				}
			}
		}		
		return "CONTINUE";
	}



	public void printPartyStatus() {
		if (w.hp > 0 && !w.isEscaped()) {
			System.out.print(w.name + "(" + w.job+ "):" + w.hp + " ");
		} 
		else if(w.isEscaped()) {
			System.out.println(w.name + "(" + w.job + "):逃亡　");
		}
		else if(w.hp <=0 ){
			System.out.println(w.name + "(" + w.job + "):死亡　");
		}
		if (s.hp > 0 && !s.isEscaped()) {
			System.out.print(s.name + "(" + s.job+ "):" + s.hp + " ");
		}			
		else if(s.isEscaped()) {
			System.out.println(s.name + "(" + s.job + "):逃亡　");
		}
		else if(s.hp <=0 ){
			System.out.println(s.name + "(" + s.job + "):死亡　");
		}
		if (p.hp > 0 && !p.isEscaped()) {
			System.out.print(p.name + "(" + p.job+ "):" + p.hp + " ");
		}		
		else if(p.isEscaped()) {
			System.out.println(p.name + "(" + p.job + "):逃亡　");
		}
		else if(p.hp <=0 ){
			System.out.println(p.name + "(" + p.job + "):死亡　");
		}

		System.out.println();
	}

	public boolean isEscapeAll() {
		if (!w.isEscaped() || !s.isEscaped() || !p.isEscaped()) {
			return false;
		}else {
			return true;
		}
	}
	
	public void() {
		w.init();
		s.init();
		p.init();
	}

}

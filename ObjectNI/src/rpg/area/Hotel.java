package rpg.area;

import rpg.ScanCommand;
import rpg.character.hero.HeroParty;

public class Hotel extends Area
{
    private String name = "宿屋";
    @Override
    public Area access(HeroParty party)
    {
        this.printArea();
        party.printPartyStatus();
        while (true)
        {
            System.out.println("どうしますか");
            System.out.println("1:休息する　2:はじまりの町へ戻る");
            int nextMove = ScanCommand.scan();
            if (nextMove == 1)
            {
                this.rest(party);
            }
            Town town = new Town();
            town.access(party);
        }
    }

    @Override
    void printArea()
    {
        System.out.println("現在の場所は" + name + "です．");
    }

    public void rest(HeroParty party)
    {
        party.rest();
    }
}

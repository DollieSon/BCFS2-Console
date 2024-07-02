import Battle.Attack;
import Battle.BattleEntity;
import Battle.BattleReport;

public class Main {
    public static void main(String[] args) {
        System.out.println("HI god");

    }

    public BattleEntity getStan(){
        BattleEntity stan = new BattleEntity("Stan");
        stan.setStat(BattleEntity.StatType.HP,100);
        stan.setStat(BattleEntity.StatType.MaxHP,100);
        return stan;
    }

    public Attack getAtck(){

    }
}

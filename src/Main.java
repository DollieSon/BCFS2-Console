import Battle.Attack;
import Battle.AttackRatio;
import Battle.BattleEntity;
import Battle.BattleReport;

public class Main {
    public static void main(String[] args) {
        System.out.println("HI god");
        BattleEntity Be = getStan();
        BattleEntity Enim = getStan();
        Be.setStat(BattleEntity.StatType.PhysAtk, 100);
        Attack ka = getAtck();
        Be.addAttack(ka);
        ka.Apply(Enim);
        System.out.println("Dead");
    }

    public static BattleEntity getStan(){
        BattleEntity stan = new BattleEntity("Stan");
        stan.setStat(BattleEntity.StatType.HP,100);
        stan.setStat(BattleEntity.StatType.MaxHP,100);
        return stan;
    }

    public static Attack getAtck(){
        Attack atk = new Attack("Basic Attack", Attack.AttackType.Physical,5);
        atk.addRatio(new AttackRatio(BattleEntity.StatType.PhysAtk, 0.1F));
        return atk;
    }
}

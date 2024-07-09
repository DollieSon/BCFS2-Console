import Battle.Attack;
import Battle.AttackEffects.OA_IncreaseSelfStrength;
import Battle.AttackEffects.On_Attack;
import Battle.AttackRatio;
import Battle.BattleEntity;
import Battle.StatusEffects.StatusEffect;
import Battle.StatusEffects.StatusEffectConstructor;

public class Main {
    public static void main(String[] args) {
        System.out.println("HI god");
        BattleEntity Be = getStan();
        BattleEntity Enim = getStan();
        Be.setStat(BattleEntity.StatType.PhysAtk, 10);
        Attack ka = getAtck();
        On_Attack inc = new OA_IncreaseSelfStrength(10);
        ka.setEffect(inc);
        Be.addAttack(ka);
        ka.Apply(Enim);
        StatusEffect sm = StatusEffectConstructor.getStatusEffect(0,Be,Be);

        System.out.println("Dead");
    }

    public static BattleEntity getStan(){
        BattleEntity stan = new BattleEntity("Stan");
        stan.setStat(BattleEntity.StatType.MaxHP,100);
        stan.setStat(BattleEntity.StatType.HP,100);
        return stan;
    }

    public static Attack getAtck(){
        Attack atk = new Attack("Basic Attack", Attack.AttackType.Physical,5);
        atk.addRatio(new AttackRatio(BattleEntity.StatType.PhysAtk, 0.1F));
        return atk;
    }

}

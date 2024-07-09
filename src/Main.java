import Battle.Attack;
import Battle.AttackEffects.OA_IncreaseSelfStrength;
import Battle.AttackEffects.On_Attack;
import Battle.AttackRatio;
import Battle.BattleEntity;
import Battle.BattleScene;
import Battle.StatusEffects.StatusEffect;
import Battle.StatusEffects.StatusEffectConstructor;

public class Main {
    public static void main(String[] args) {
        System.out.println("HI god");
        BattleEntity player = getStan();
        BattleEntity enemy = getGoblin();
        BattleScene bs = new BattleScene(player,enemy);
        System.out.println("-------Battle-----");
        System.out.println(player);
        System.out.println(enemy);
        System.out.println("-------Battle Start-----");
        bs.startBattle();

    }

    public static BattleEntity getStan(){
        BattleEntity stan = new BattleEntity("Stan");
        stan.setStat(BattleEntity.StatType.MaxHP,100);
        stan.setStat(BattleEntity.StatType.HP,100);
        stan.setStat(BattleEntity.StatType.PhysAtk, 10);
        stan.setStat(BattleEntity.StatType.Speed,1000);
        Attack atk1 = getAtck();
        Attack atk2 = getAtck();
        stan.addAttack(atk1);
        stan.addAttack(atk2);
        return stan;
    }

    public static Attack getAtck(){
        Attack atk = new Attack("Basic Attack", Attack.AttackType.Physical,5);
        atk.addRatio(new AttackRatio(BattleEntity.StatType.PhysAtk, 0.1F));
        return atk;
    }
    public static BattleEntity getGoblin(){
        BattleEntity res = getStan();
        res.setName("Goblin");
        res.setStat(BattleEntity.StatType.MaxHP,40);
        res.setStat(BattleEntity.StatType.HP,40);
        res.setStat(BattleEntity.StatType.PhysAtk,7);
        res.setStat(BattleEntity.StatType.Speed,50);
        return res;
    }

}

package Important;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Entity {

    private String name;
    private int[] baseStat;
    private int[] bonusStat;
    private PriorityQueue<Attack> AttackQueue;

    public static enum StatType{
        HP,
        TempHp,
        ATK,
        SPD,
        MN
    }



    public Entity(String name,int hp,int atk,int spd,int mn){
        this.name = name;
        baseStat = new int[StatType.values().length];
        baseStat[StatType.ATK.ordinal()] = atk;
        baseStat[StatType.HP.ordinal()] = hp;
        baseStat[StatType.TempHp.ordinal()] = hp;
        baseStat[StatType.SPD.ordinal()] = spd;
        baseStat[StatType.MN.ordinal()] = mn;
        bonusStat = new int[baseStat.length];
        AttackQueue = new PriorityQueue<>(new Attack.SortBySpeed());
    }

    /*Getters and Setters Here*/

    public Entity addAttack(Attack a){
        AttackQueue.add(a);
        return this;
    }
    public Attack getTopAttack(){
        return AttackQueue.remove();
    }
    public int getBaseStat(StatType ind){
        return baseStat[ind.ordinal()];
    }
    public int getBonusStat(StatType ind){
        return bonusStat[ind.ordinal()];
    }
    public int getStat(StatType ind){
        return getBaseStat(ind) + getBonusStat(ind);
    }
    public Entity setBonusStat(StatType ind, int num){
        bonusStat[ind.ordinal()] = num;
        return this;
    }

    public String getName() {
        return name;
    }

    public Entity setName(String name) {
        this.name = name;
        return this;
    }
    /*End of Getters and Setters*/
}

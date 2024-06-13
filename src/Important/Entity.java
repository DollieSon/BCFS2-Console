package Important;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Set;

public class Entity implements Cloneable{

    private String name;
    private int[] baseStat;
    private int[] bonusStat;
    private PriorityQueue<Attack> AttackQueue;

    public static enum StatType{
        HP,
        ATK,
        SPD,
        MN
    }


    public Entity(String name,int hp,int atk,int spd,int mn){
        this.name = name;
        baseStat = new int[StatType.values().length];
        baseStat[StatType.ATK.ordinal()] = atk;
        baseStat[StatType.HP.ordinal()] = hp;
        baseStat[StatType.SPD.ordinal()] = spd;
        baseStat[StatType.MN.ordinal()] = mn;
        bonusStat = new int[baseStat.length];
        AttackQueue = new PriorityQueue<>(new Attack.SortBySpeed());
    }

    /*Getters and Setters Here*/

    public Entity addAttack(Attack a){
        AttackQueue.add(a);
        a.setOwner(this);
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
    public boolean isAlive(){
        return getStat(StatType.HP) > 0;
    }
    public DamagePromise applyDamagePromise(DamagePromise dp, Set<DamagePromise.StatType> CompareStat){
        DamagePromise reflect = new DamagePromise();
        Set<DamagePromise.StatType> keys = dp.getKeys();
        for(DamagePromise.StatType st : keys){
            if(!CompareStat.contains(st)) continue;
            switch (st){
                case DamageDealt:
                    int finalDamage = dp.getValue(st);
                    finalDamage = getStat(StatType.HP) - finalDamage;
                    setBonusStat(StatType.HP,finalDamage);
                    break;
                case DamageHealed:
                    int finalHeal = dp.getValue(st);
                    finalHeal = getBaseStat(StatType.HP) + finalHeal;
                    setBonusStat(StatType.HP,finalHeal);
                    break;
            }
        }
        //apply Thorns Passive or something;

        return reflect;
    }

    public Entity clone() throws CloneNotSupportedException {
        int HP = this.getBaseStat(StatType.HP);
        int ATK = this.getBaseStat(StatType.ATK);
        int SPD = this.getBaseStat(StatType.SPD);
        int MN = this.getBaseStat(StatType.MN);
        Entity res = new Entity(this.name,HP,ATK,SPD,MN);
        Iterator<Attack> atk = AttackQueue.iterator();;
        while(atk.hasNext()){
            res.addAttack(atk.next().clone());
        }
        return res;
    }
}

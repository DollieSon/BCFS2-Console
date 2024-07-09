package Battle;


import Battle.StatusEffects.StatusEffect;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class BattleEntity {
    private String name;
    private int[] stats;
    private PriorityQueue<Attack> attackQueue;
    public ArrayList<StatusEffect> statusEffects;

    public static enum StatType{
        HP,
        MaxHP,
        Shield,
        PhysAtk,
        MgcAtk,
        PhysDef,
        MgcDef,
        PhysDefPen,
        MgcDefPen,
        Speed,
    }

    public BattleEntity(String name){
        this.name = name;
        stats = new int[StatType.values().length];
        attackQueue = new PriorityQueue<>(new Attack.SortBycSpeed());
        statusEffects = new ArrayList<>();
    }

    public Integer getStat(StatType st){
        return stats[st.ordinal()];
    }
    public BattleEntity setStat(StatType st, int val){
        if(st == StatType.HP && val > stats[StatType.MaxHP.ordinal()]) val = stats[StatType.MaxHP.ordinal()];
        stats[st.ordinal()] = val;
        return this;
    }
    public BattleEntity addStat(StatType st, int val){
        stats[st.ordinal()] += val;
        return this;
    }

    public BattleEntity addStatusEffect(StatusEffect se){
        statusEffects.add(se);
        return this;
    }
    public BattleEntity removeStatusEffect(StatusEffect se){
        statusEffects.remove(se);
        return this;
    }
    /** returns all the activated effect **/
    public int tickStatusEffects(){
        int activated = 0;
        for(StatusEffect se: statusEffects){
            activated+=se.Tick();
        }
        return activated;
    }

    public BattleEntity setName(String name) {
        this.name = name;
        return this;
    }

    public BattleEntity addAttack(Attack atk){
        atk.setOwner(this);
        attackQueue.add(atk);
        return this;
    }
    public Attack getTopAttack(){
        return attackQueue.remove();
    }
    public String getName(){
        return name;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder(name);
        sb.append(" ");
        for(int x = 0 ;x < stats.length;x++){
            sb.append(" ").append(StatType.values()[x].toString()).append(": ").append(stats[x]);
        }
        for(Attack atk : attackQueue){
            sb.append("|").append(atk.toString()).append("|");
        }
        return sb.toString();
    }
    public boolean isAlive(){
        return getStat(StatType.HP) > 0;
    }
}

package Battle;


import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class BattleEntity {
    private String name;
    private int[] stats;
    private PriorityQueue<Attack> attackQueue;

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

    public BattleEntity addAttack(Attack atk){
        atk.setOwner(this);
        attackQueue.add(atk);
        return this;
    }
    public Attack getTopAttack(){
        return attackQueue.remove();
    }

}

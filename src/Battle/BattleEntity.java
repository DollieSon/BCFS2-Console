package Battle;


import java.util.PriorityQueue;

public class BattleEntity {
    private String name;
    private int[] stats;
    private PriorityQueue<Attack> attackQueue;

    public static enum StatType{
        HP,
        MaxHP,
        Shield,
        MaxShield,
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

    public int getStat(StatType st){
        return stats[st.ordinal()];
    }
    public BattleEntity setStat(StatType st, int val){
        stats[st.ordinal()] = val;
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

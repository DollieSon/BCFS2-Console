package Battle;

public class AttackRatio {
    public BattleEntity.StatType type;
    public float ratio;

    public AttackRatio(BattleEntity.StatType t, float r){
        ratio = r;
        type = t;
    }
}

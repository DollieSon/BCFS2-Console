package Battle.StatusEffects.Buffs;

import Battle.BattleEntity;
import Battle.StatusEffects.StatusEffect;

public class TempIncreaseStr extends StatusEffect {
    private int increaseAmt;

    public TempIncreaseStr(BattleEntity t, BattleEntity s, int max,int increaseAmt) {
        super(t, s, max);
        this.increaseAmt = increaseAmt;
    }


    @Override
    public void activateStatus() {
        target.addStat(BattleEntity.StatType.PhysAtk,-increaseAmt);
        target.removeStatusEffect(this);
    }

    @Override
    public void initApply() {
        target.addStat(BattleEntity.StatType.PhysAtk,increaseAmt);
    }

    @Override
    public void tickEffect() {

    }
}

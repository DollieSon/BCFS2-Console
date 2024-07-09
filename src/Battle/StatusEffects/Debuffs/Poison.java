package Battle.StatusEffects.Debuffs;

import Battle.BattleEntity;
import Battle.StatusEffects.StatusEffect;

public class Poison extends StatusEffect {
    int dmg;
    public Poison(BattleEntity t, BattleEntity s, int max,int dmgPerTurn) {
        super(t, s, max);
        dmg= dmgPerTurn;
    }

    @Override
    public void activateStatus() {
        target.removeStatusEffect(this);
    }

    @Override
    public void initApply() {

    }

    @Override
    public void tickEffect() {
        int prev  = target.getStat(BattleEntity.StatType.MgcDef)/2;
        int statdmg = dmg - prev;
        if(statdmg < 0) statdmg = 0;
        target.addStat(BattleEntity.StatType.HP,-statdmg);
    }
}

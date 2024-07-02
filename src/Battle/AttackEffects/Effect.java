package Battle.AttackEffects;

import Battle.BattleEntity;
import Battle.BattleReport;

public abstract class Effect {
    public EffectType effectType;
    public abstract BattleReport apply(BattleEntity target);
}

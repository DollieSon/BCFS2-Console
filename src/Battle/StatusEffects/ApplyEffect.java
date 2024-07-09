package Battle.StatusEffects;

import Battle.BattleEntity;

public interface ApplyEffect {
    void apply(BattleEntity target, BattleEntity source);
}

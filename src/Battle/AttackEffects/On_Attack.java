package Battle.AttackEffects;

import Battle.Attack;
import Battle.BattleEntity;
import Battle.BattleReport;

public abstract class On_Attack {
    Attack attackOwner;

    public On_Attack setOwner(Attack owner) {
        attackOwner = owner;
        return this;
    }

    public abstract BattleReport apply(BattleEntity target);
}

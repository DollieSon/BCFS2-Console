package AttackModules;

import Important.Attack;
import Important.Entity;
import Statistics.DamagePromise;

public abstract class AttackModule {
    private Attack Attackparent;

    public abstract DamagePromise apply(Entity target);

    public AttackModule setAttackparent(Attack attackparent) {
        Attackparent = attackparent;
        return this;
    }
    public Attack getAttackparent(){
        return Attackparent;
    }
}

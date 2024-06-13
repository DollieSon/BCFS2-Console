package AttackModules;

import Important.Attack;
import Important.Entity;
import Important.DamagePromise;

public abstract class AttackModule implements Cloneable{
    private Attack Attackparent;

    public abstract DamagePromise apply(Entity target);

    public AttackModule setAttackparent(Attack attackparent) {
        Attackparent = attackparent;
        return this;
    }
    public Attack getAttackparent(){
        return Attackparent;
    }

    //Might only clone the AttackModule and not the Child itself;
    @Override
    public AttackModule clone() {
        try {
            AttackModule clone = (AttackModule) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

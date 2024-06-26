package AttackModules;

import Important.Attack;
import Important.Entity;
import Important.DamagePromise;

public class SingleAttack extends AttackModule{
    @Override
    public DamagePromise apply(Entity target) {
        DamagePromise res = new DamagePromise();
        Attack atkparent = getAttackparent();
        Entity owner = atkparent.getOwner();
        int Damage = atkparent.getDamage() + owner.getStat(Entity.StatType.ATK);
        res.addInsertValue(DamagePromise.StatType.DamageDealt,Damage);
        return res;
    }
}

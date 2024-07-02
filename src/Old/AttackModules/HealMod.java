package Old.AttackModules;

import Old.Important.DamagePromise;
import Old.Important.Entity;

public class HealMod extends AttackModule{
    @Override
    public DamagePromise apply(Entity target) {
        DamagePromise res = new DamagePromise();
        int heal_amt = getAttackparent().getDamage() +
                getAttackparent().getOwner().getStat(Entity.StatType.ATK);
        getAttackparent().getOwner().setBonusStat(Entity.StatType.MN,- getAttackparent().getManaCost());
        res.addInsertValue(DamagePromise.StatType.HealthHealed,heal_amt);
        return res;
    }
}

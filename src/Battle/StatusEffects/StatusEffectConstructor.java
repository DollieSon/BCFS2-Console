package Battle.StatusEffects;

import Battle.BattleEntity;
import Battle.StatusEffects.Buffs.TempIncreaseStr;

public class StatusEffectConstructor {
    public static StatusEffect getStatusEffect(int statCode, BattleEntity source, BattleEntity target) throws IndexOutOfBoundsException{
        if(statCode == 0){
            return new TempIncreaseStr(target,source,3,10);
        }
        throw new IndexOutOfBoundsException("statCode not Found");
    }
}

package Statistics;

import java.util.HashMap;
import java.util.Set;

public class DamagePromise {

    public static enum StatType{
        DamageDealt,
        DamageHealed
    }

    private HashMap<StatType,Integer> promiseMap;
    public DamagePromise(){
        promiseMap = new HashMap<>();
    }

    public int getValue(StatType key){
        return promiseMap.get(key);
    }
    public Set<StatType> getKeys(){
        return promiseMap.keySet();
    }
    public DamagePromise addInsertValue(StatType type, int some){
        promiseMap.compute(type,(key,val)-> (val == null) ? 1 : val+ 1);
        return this;
    }
}

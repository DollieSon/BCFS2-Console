package Old.Important;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class DamagePromise {

    public static enum StatType{
        DamageDealt,
        HealthHealed,
        ManaReduce,
        ManaGain
    }

    public static Set<StatType> postiveTypes = new HashSet<>(){{
        add(StatType.HealthHealed);
        add(StatType.ManaGain);
    }};

    public static Set<StatType> negativeTypes = new HashSet<>(){{
        add(StatType.DamageDealt);
        add(StatType.ManaReduce);
    }};

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
        promiseMap.compute(type,(key,val)-> (val == null) ? some : val+ some);
        return this;
    }
}

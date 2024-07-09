package Battle.StatusEffects;

import Battle.BattleEntity;
import Battle.BattleReport;

public class StatusEffect {
    ApplyEffect effect;
    BattleEntity target;
    BattleEntity source;
    int currTick;
    int maxTick;

    public StatusEffect(ApplyEffect e, BattleEntity t, BattleEntity s, int max){
        effect = e;
        target = t;
        source = s;
        currTick = 0;
        maxTick = max;
    }

    public int Tick(){
        currTick+=1;
        if(currTick >= maxTick){
            effect.apply(target,source);
            // TODO:: Also Remove the status effect or something
            return 1;
        }
        return 0;
    }
    public int Tick(int x){
        while(x >= 1){
            x--;
            if(Tick() == 1)return 1;
        }
        return 0;
    }

}

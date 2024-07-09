package Battle.StatusEffects;

import Battle.BattleEntity;
import Battle.BattleReport;

public abstract class StatusEffect {
    protected BattleEntity target;
    protected BattleEntity source;
    int currTick;
    int maxTick;

    public StatusEffect(BattleEntity t, BattleEntity s, int max){
        target = t;
        source = s;
        currTick = 0;
        maxTick = max;
        initApply();
    }

    public abstract void activateStatus();
    public abstract void initApply();
    public abstract void tickEffect();
    public int Tick(){
        currTick+=1;
        tickEffect();
        if(currTick >= maxTick){
            activateStatus();
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

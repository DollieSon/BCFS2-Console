package Battle.AttackEffects;

import Battle.BattleEntity;
import Battle.BattleReport;
import Battle.ReportIndex;

public class OA_IncreaseSelfStrength extends On_Attack{
    private int IncreaseAmt;

    public OA_IncreaseSelfStrength(int IncreaseAmt) {
        this.IncreaseAmt = IncreaseAmt;
    }

    @Override
    public BattleReport apply(BattleEntity target) {
        BattleReport br = new BattleReport();
        br.report.put(ReportIndex.PhysIncreased,IncreaseAmt);
        attackOwner.getOwner().addStat(BattleEntity.StatType.PhysAtk,IncreaseAmt);
        return br;
    }
}

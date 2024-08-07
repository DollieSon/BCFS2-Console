package Battle;


import Battle.AttackEffects.Effect;
import Battle.AttackEffects.On_Attack;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Attack {
    private String name;
    private AttackType type;
    private BattleEntity owner;
    private On_Attack effect;
    private int speed;
    private int currSpeed;
    private ArrayList<AttackRatio> attackRatios;

    public static enum AttackType{
        Physical,
        Magic
    }

    public Attack(String name,AttackType t, int speed){
        this.name = name;
        type = t;
        this.speed = speed;
        currSpeed = speed;
        attackRatios = new ArrayList<>();
    }
    public Attack addRatio(AttackRatio ar){
        attackRatios.add(ar);
        return this;
    }

    public Attack setOwner(BattleEntity owner) {
        this.owner = owner;
        return this;
    }

    public Attack setEffect(On_Attack effect) {
        this.effect = effect;
        effect.setOwner(this);
        return this;
    }

    public BattleEntity getOwner() {
        return owner;
    }

    public Attack incementSpeed(){
        currSpeed+= speed;
        return this;
    }
    public int getCurrSpeed(){
        return currSpeed;
    }

    public static class SortBycSpeed implements Comparator<Attack>{
        @Override
        public int compare(Attack o1,Attack o2) {
            return Integer.compare(o1.currSpeed,o2.currSpeed);
        }
    }

    public BattleReport Apply(BattleEntity target){
        // Damage Calc dmg-(def - (pen*2))
        System.out.println(owner.getName() + " Attacks " + target.getName() + " Using " + name);
        BattleReport br = new BattleReport();
        int def;
        int pen;
        int damage =0;
        if(type == AttackType.Physical){
            def = target.getStat(BattleEntity.StatType.PhysDef);
            pen = owner.getStat(BattleEntity.StatType.PhysDefPen);
        }else{
            def = target.getStat(BattleEntity.StatType.MgcDef);
            pen = owner.getStat(BattleEntity.StatType.MgcDefPen);
        }
        for(AttackRatio ar : attackRatios){
            damage += (int)Math.ceil((owner.getStat(ar.type) * ar.ratio));
        }
        def -= pen*2;
        if(def<0) def = 0;
        damage-=def;
        int newHealth = target.getStat(BattleEntity.StatType.HP) - damage;
        target.setStat(BattleEntity.StatType.HP,newHealth);
        if(effect != null){
            effect.apply(target);
        }
        return br;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder(name);
        sb.append(" cP:");
        sb.append(currSpeed);
        sb.append(" ");
        for(AttackRatio ar : attackRatios){
            sb.append(ar.toString()+ " ");
        }
        return sb.toString();
    }
}

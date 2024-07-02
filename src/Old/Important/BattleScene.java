package Old.Important;

public class BattleScene {
    private Entity Player;
    private Entity Enemy;
    private boolean isDoneFignting;
    private Entity Winner;
    public BattleScene(Entity P,Entity E){
        try {
            Enemy = E.clone();
            Player = P.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        isDoneFignting = false;
        Winner = null;
    }
    public void Fight(){
        while(isDoneFignting == false){
            Attack playerAttack = Player.getTopAttack();
            Attack enemyAttack = Enemy.getTopAttack();
            Attack chosenAttack = Player.getStat(Entity.StatType.SPD) + playerAttack.getCurrspeed() <= Enemy.getBaseStat(Entity.StatType.SPD) + enemyAttack.getCurrspeed() ? playerAttack : enemyAttack;
            Entity target = chosenAttack.getOwner() == Player ? Enemy : Player;
            DamagePromise dp = chosenAttack.appply(target);
            System.out.println(chosenAttack.getOwner().getName() + " Attacks");
            //apply level mods Here
            DamagePromise reflectDp = target.applyDamagePromise(dp,DamagePromise.negativeTypes);
            chosenAttack.getOwner().applyDamagePromise(dp,DamagePromise.postiveTypes);
            //
            chosenAttack.getOwner().applyDamagePromise(reflectDp,DamagePromise.negativeTypes);
            chosenAttack.incrementSpeed();
            Enemy.addAttack(enemyAttack);
            Player.addAttack(playerAttack);
            if(!Enemy.isAlive() || !Player.isAlive()){
                isDoneFignting = true;
            }
            if(!Enemy.isAlive() && Player.isAlive()){
                Winner = Player;
            }else if(!Player.isAlive() && Enemy.isAlive()){
                Winner = Enemy;
            }
            // null == Both are dead
        }
        System.out.println(Winner.getName() + " Wins");
    }
}

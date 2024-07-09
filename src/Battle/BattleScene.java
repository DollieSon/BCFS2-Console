package Battle;

public class BattleScene {
    BattleEntity player;
    BattleEntity enemy;


    /**@param e enemy
     * @param p player**/
    public BattleScene(BattleEntity p, BattleEntity e){
        player = p;
        enemy = e;
    }

    public void startBattle(){
        while(player.isAlive() && enemy.isAlive()){
            Attack playerAttack = player.getTopAttack();
            Attack enemyAttack = enemy.getTopAttack();
            Attack chosenAttack;
            BattleEntity target;
            if(player.getStat(BattleEntity.StatType.Speed) + playerAttack.getCurrSpeed() <
            enemy.getStat(BattleEntity.StatType.Speed) + enemyAttack.getCurrSpeed()){
                // player attacks
                chosenAttack = playerAttack;
                target = enemy;
            }else{
                //enemy attacks
                chosenAttack = enemyAttack;
                target = player;
            }
            chosenAttack.Apply(target);
            chosenAttack.incementSpeed();
            player.addAttack(playerAttack);
            enemy.addAttack(enemyAttack);
            System.out.println();
            System.out.println(player);
            System.out.println(enemy);
        }
        if(player.isAlive()){
            System.out.println("Enemy Died");
        }
        if(enemy.isAlive()){
            System.out.println("Player Died");
        }
    }


}

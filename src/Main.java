import AttackModules.SingleAttack;
import Important.Attack;
import Important.BattleScene;
import Important.Entity;

public class Main {
    public static void main(String[] args) {
        System.out.println("HI god");
        Attack PlayerAtk1 = new Attack("Player Super",10,4,new SingleAttack());
        Attack PlayerAtk2 = new Attack("Player Smart",40,10,new SingleAttack());
        Attack PlayerAtk3 = new Attack("Player Pooper",4,2,new SingleAttack());

        Attack EnemyAtk1 = new Attack("Emeny Super",1,4,new SingleAttack());
        Attack EnemyAtk2 = new Attack("Keke Super",10,7,new SingleAttack());

        Entity Enemy = new Entity("Globlin",100,5,8,10);
        Entity Player = new Entity("Flurgin",60,5,7,10);
        Enemy.addAttack(EnemyAtk1).addAttack(EnemyAtk2);
        Player.addAttack(PlayerAtk1).addAttack(PlayerAtk2).addAttack(PlayerAtk3);

        BattleScene bs = new BattleScene(Player,Enemy);
        bs.Fight();
    }
}

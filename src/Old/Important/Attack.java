package Old.Important;

import Old.AttackModules.AttackModule;

import java.util.ArrayList;
import java.util.Comparator;

public class Attack implements Cloneable{
    private String name;
    private int damage;
    private int speed;
    private int currspeed;
    private Entity owner;
    private AttackModule effect;
    private int ManaCost;
    private ArrayList<Integer> MagicNumbers;
    public Attack(String name,int damage,int speed,AttackModule mod) {
        this.damage = damage;
        this.name = name;
        this.speed = speed;
        currspeed = speed;
        effect = mod;
        effect.setAttackparent(this);
        ManaCost = 0;
        MagicNumbers = new ArrayList<>();
    }

    /* Getters And Setters Here*/

    public Entity getOwner() {
        return owner;
    }

    public Attack setOwner(Entity owner) {
        //if(this.owner != null) System.out.println(name + "WARNING: Attack already has an owner " + owner.getName());
        this.owner = owner;
        return this;
    }

    public int getSpeed() {
        return speed;
    }

    public int getDamage() {
        return damage;
    }

    public Attack setDamage(int damage) {
        this.damage = damage;
        return this;
    }

    public int getCurrspeed() {
        return currspeed;
    }

    public Attack setCurrspeed(int currspeed) {
        this.currspeed = currspeed;
        return this;
    }

    public ArrayList<Integer> getMagicNumbersArr() {
        return MagicNumbers;
    }
    public int getMagicNumber(int ind){
        return ind >=MagicNumbers.size()? 0:MagicNumbers.get(ind);
    }
    public Attack addMagicNumber(int num){
        MagicNumbers.add(num);
        return this;
    }

    public Attack setMagicNumbers(ArrayList<Integer> magicNumbers) {
        MagicNumbers = magicNumbers;
        return this;
    }

    public int getManaCost() {
        return ManaCost;
    }

    public Attack setManaCost(int manaCost) {
        ManaCost = manaCost;
        return this;
    }

    public boolean isCastable(){
        return ManaCost <= getOwner().getStat(Entity.StatType.MN);
    }


    public int incrementSpeed(){
        int cp = getCurrspeed() + getSpeed();
        setCurrspeed(cp);
        return getCurrspeed();
    }


    public DamagePromise appply(Entity target){
        return effect.apply(target);
    }

    @Override
    protected Attack clone() throws CloneNotSupportedException {
        Attack res = new Attack(this.name,
                this.damage,
                this.speed,
                effect.clone());
        res.setManaCost(this.ManaCost);
        res.setMagicNumbers(new ArrayList<>(MagicNumbers));
        return res;
    }

    public static class SortBySpeed implements Comparator<Attack>{
        @Override
        public int compare(Attack o1, Attack o2) {
            return Integer.compare(o1.currspeed,o2.currspeed);
        }
    }
}

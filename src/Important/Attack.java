package Important;

import java.util.Comparator;

public class Attack {
    private String name;
    private int damage;
    private int speed;
    private int currspeed;
    private Entity owner;

    public Attack(int damage, String name, int speed) {
        this.damage = damage;
        this.name = name;
        this.speed = speed;
        currspeed = speed;
    }

    /* Getters And Setters Here*/

    public Entity getOwner() {
        return owner;
    }

    public Attack setOwner(Entity owner) {
        if(this.owner != null) System.out.println(name + "WARNING: Attack already has an owner " + owner.getName());
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
    public int incrementSpeed(){
        int cp = getCurrspeed() + getSpeed();
        setCurrspeed(cp);
        return getCurrspeed();
    }


    public static class SortBySpeed implements Comparator<Attack>{
        @Override
        public int compare(Attack o1, Attack o2) {
            return Integer.compare(o1.currspeed,o2.currspeed);
        }
    }
}

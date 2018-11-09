package p6;

public abstract class Character {
    private int exp;


    public int getExp() {
        return exp;
    }

    public void addExp(int n) {
        exp += n;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public abstract boolean canFly();
    public abstract boolean canSpeak();
}

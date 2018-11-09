package patterns.adapter;

public class WarriorAdapter extends Warrior implements Knight{

    @Override
    public void shoutout() {
        yell();
    }

    @Override
    public void beat() {
        kick();
    }
}

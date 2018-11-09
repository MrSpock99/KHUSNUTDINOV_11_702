package patterns.proxy;

public class NuckImpl implements Nuck{
    private String target;

    public NuckImpl(String target){
        setTarget(target);
        shoot();
    }

    @Override
    public void shoot() {
        System.out.println("BOOM!");
    }

    public void setTarget(String target) {
        this.target = target;
    }
}

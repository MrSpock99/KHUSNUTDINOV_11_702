package patterns.proxy;

public class NuckProxy implements Nuck{
    private String target;
    private NuckImpl nuck;

    public NuckProxy(String target){
        setTarget(target);
    }
    @Override
    public void shoot() {
        if (nuck == null){
            nuck = new NuckImpl(target);
        }
        nuck.shoot();
    }

    public void setTarget(String target) {
        this.target = target;
    }
}

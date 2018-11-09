package patterns.command;

//Invoker cars
public class Switch {
    private Command on;
    private Command off;

    public Switch(Command on,Command off){
        this.on = on;
        this.off = off;
    }

    public void turnOn(){
        on.execute();
    }

    public void turnOff(){
        off.execute();
    }

}

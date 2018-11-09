package patterns.command;

public class TurnOnCommand implements Command {
    private LightBulb lightBulb;

    public TurnOnCommand(LightBulb lightBulb){
        this.lightBulb = lightBulb;
    }
    @Override
    public void execute() {
        lightBulb.turnOn();
    }

    @Override
    public void unexecute() {

    }
}

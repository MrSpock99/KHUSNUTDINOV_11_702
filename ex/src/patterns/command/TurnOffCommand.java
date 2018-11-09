package patterns.command;

public class TurnOffCommand implements Command{
    private LightBulb lightBulb;

    public TurnOffCommand(LightBulb lightBulb){
        this.lightBulb = lightBulb;
    }
    @Override
    public void execute() {
        lightBulb.turnOff();
    }

    @Override
    public void unexecute() {

    }
}

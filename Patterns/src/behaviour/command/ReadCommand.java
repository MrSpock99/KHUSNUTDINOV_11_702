package behaviour.command;

public class ReadCommand implements Command {
    private Database database;

    public ReadCommand(Database database) {
        this.database = database;
    }

    @Override
    public void execute() {
        database.read();
    }
}

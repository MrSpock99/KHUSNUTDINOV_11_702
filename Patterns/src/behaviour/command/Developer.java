package behaviour.command;

public class Developer {
    private InsertCommand insertCommand;
    private UpdateCommand updateCommand;
    private ReadCommand readCommand;
    private DeleteCommand deleteCommand;

    public Developer(InsertCommand insertCommand, UpdateCommand updateCommand, ReadCommand readCommand, DeleteCommand deleteCommand) {
        this.insertCommand = insertCommand;
        this.updateCommand = updateCommand;
        this.readCommand = readCommand;
        this.deleteCommand = deleteCommand;
    }

    public void insertRecord() {
        insertCommand.execute();
    }


    public void deleteRecord() {
        deleteCommand.execute();
    }

    public void readRecord() {
        readCommand.execute();
    }


    public void updateRecord() {
        updateCommand.execute();
    }
}

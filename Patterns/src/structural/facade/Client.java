package structural.facade;

public class Client {
    public static void main(String[] args) {
        WorkFlow workFlow = new WorkFlow(new Developer(), new Job(), new BugTracker());
        workFlow.solveProblems();
    }
}

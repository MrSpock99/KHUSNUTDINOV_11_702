package structural.facade;

public class WorkFlow {
    private Developer developer;
    private Job job;
    private BugTracker bugTracker;

    public WorkFlow(Developer developer, Job job, BugTracker bugTracker) {
        this.developer = developer;
        this.job = job;
        this.bugTracker = bugTracker;
    }

    public void solveProblems(){
        job.doJob();
        bugTracker.startSprint();
        developer.doJobBeforeDeadline(bugTracker);
    }
}

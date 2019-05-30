package structural.facade;

public class Developer {
    public void doJobBeforeDeadline(BugTracker tracker){
        if (tracker.isSprintActive()){
            System.out.println("Write some code...");
        }else {
            System.out.println("fap fap fap");
        }
    }
}

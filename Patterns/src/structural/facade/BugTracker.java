package structural.facade;

public class BugTracker {
    private boolean isSprintActive;

    public boolean isSprintActive() {
        return isSprintActive;
    }

    public void setSprintActive(boolean sprintActive) {
        isSprintActive = sprintActive;
    }

    public void startSprint(){
        isSprintActive = true;
    }

    public void endSprint(){
        isSprintActive = false;
    }
}

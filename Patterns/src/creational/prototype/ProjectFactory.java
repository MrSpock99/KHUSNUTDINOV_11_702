package creational.prototype;

public class ProjectFactory {
    private Project project;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Project getCopy(){
        return (Project) project.copy();
    }
}

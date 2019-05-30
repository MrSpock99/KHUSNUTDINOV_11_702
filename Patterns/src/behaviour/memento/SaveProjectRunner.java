package behaviour.memento;

public class SaveProjectRunner {
    public static void main(String[] args) {
        Project project = new Project();
        GithubRepo githubRepo = new GithubRepo();

        project.setVersionAndDate("1.0");

        githubRepo.setSave(project.save());

        System.out.println("Updating project");

        project.setVersionAndDate("1.1");

        System.out.println("Smth went wrong, need to roll back");

        project.load(githubRepo.getSave());

    }
}

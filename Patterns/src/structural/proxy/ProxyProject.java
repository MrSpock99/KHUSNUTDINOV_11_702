package structural.proxy;

public class ProxyProject implements Project {
    private String url;
    private Project realProject;

    public ProxyProject(String url) {
        this.url = url;
    }

    @Override
    public void run() {
        if (realProject == null){
            realProject = new RealProject(url);
        }
        realProject.run();
    }
}

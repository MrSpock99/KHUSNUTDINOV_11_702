package creational.prototype;

public class Project implements Copyable{
    private String name;
    private String url;
    private String sourceCode;

    public Project(String name, String url, String sourceCode) {
        this.name = name;
        this.url = url;
        this.sourceCode = sourceCode;
    }

    @Override
    public Object copy() {
        return new Project(name,url,sourceCode);
    }

    @Override
    public String toString() {
        return "Project{" +
                "name=" + name +
                ", url=" + url +
                ", sourceCode=" + sourceCode +
                '}';
    }
}

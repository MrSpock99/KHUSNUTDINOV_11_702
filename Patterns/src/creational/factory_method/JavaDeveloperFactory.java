package creational.factory_method;

public class JavaDeveloperFactory implements DeveloperFactory{
    @Override
    public Developer getDeveloper() {
        return new JavaDeveloper();
    }
}

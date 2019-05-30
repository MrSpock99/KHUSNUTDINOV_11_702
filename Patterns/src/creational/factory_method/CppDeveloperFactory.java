package creational.factory_method;

public class CppDeveloperFactory implements DeveloperFactory{

    @Override
    public Developer getDeveloper() {
        return new CppDeveloper();
    }
}

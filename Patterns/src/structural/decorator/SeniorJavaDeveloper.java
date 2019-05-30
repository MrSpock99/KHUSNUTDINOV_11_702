package structural.decorator;

public class SeniorJavaDeveloper extends DeveloperDecorator {
    public SeniorJavaDeveloper(Developer developer) {
        super(developer);
    }

    public String makeReview() {
        return " Make review";
    }

    @Override
    public String makeJob() {
        return super.makeJob() + makeReview();
    }
}

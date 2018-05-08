public class Car {
    private String name;
    private int personId;

    public Car(int personId,String name) {
        this.name = name;
        this.personId = personId;
    }


    public int getPersonId() {
        return personId;
    }

    public String getName() {
        return name;
    }
}

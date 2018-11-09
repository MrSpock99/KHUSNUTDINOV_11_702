package practice22;

public class AttackWithGun implements AttackWay {
    @Override
    public void attack(Character character) {
        System.out.println("Стреялю из пистолета");
    }
}

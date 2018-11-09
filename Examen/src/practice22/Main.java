package practice22;

public class Main {
    public static void main(String[] args) {
        Warrior adventurer = new Warrior();
        adventurer.shoutOut();
        Warrior evilGuy = new Warrior();

        //Изначально персонаж может атаковать кулаками
        adventurer.performAttack(evilGuy);

        //Персонаж нашел нож
        AttackWay attackWithKnife = new AttackWithKnife();
        adventurer.addAttackWay(attackWithKnife);

        //Персонаж может атаковать с ножем
        adventurer.setAttackWay(attackWithKnife);
        adventurer.performAttack(evilGuy);

        //Персонаж нашел пистолет
        AttackWay attackWithGun = new AttackWithGun();
        adventurer.addAttackWay(attackWithGun);

        //Персонаж может атаковать с пистолетом
        adventurer.setAttackWay(attackWithGun);
        adventurer.performAttack(evilGuy);

        //Персонаж может сменить оружие
        adventurer.setAttackWay(attackWithKnife);
        adventurer.performAttack(evilGuy);

        //У персонажа оружия может и не быть
        adventurer.setAttackWay(attackWay -> System.out.println("Стреляю из лука!"));

    }
}

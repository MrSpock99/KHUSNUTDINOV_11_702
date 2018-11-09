package practice22;

import java.util.ArrayList;
import java.util.List;

public abstract class Character {
    private AttackWay attackWay;
    private List<AttackWay> attackWays;

    public Character(){
        attackWays = new ArrayList<>();
        //Изначально можно атаковать кулаками
        attackWay = new AttackWIthFist();
    }

    //Атакуем
    public void performAttack(Character character){
        attackWay.attack(character);
    }

    //Добавляем оружие в инвентарь
    public void addAttackWay(AttackWay attackWay){
        attackWays.add(attackWay);
    }

    //Меняем оружие
    public void setAttackWay(AttackWay attackWay){
        this.attackWay = null;
        for (AttackWay way : attackWays){
            if (way.equals(attackWay)){
                this.attackWay = way;
                System.out.println("Меняю оружие");
                break;
            }
        }
        if (this.attackWay == null){
            System.out.println("Этот предмет отсутсвует в инвентаре");
        }
    }


}

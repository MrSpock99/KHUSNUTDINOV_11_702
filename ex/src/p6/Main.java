package p6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Character snake = new Snake();

        System.out.println("Start the game?");

        Scanner scanner = new Scanner(System.in);
        String action = scanner.next();

        while (!action.equals("end")){
            System.out.println("You see an enemy");
            action = scanner.next();
            if (action.equals("attack")){
                System.out.println("You killed an enemy and earned 50 exp");
                snake.addExp(50);
                System.out.println("Now you have " + snake.getExp() + " exp");

            }
            if (snake.getExp() >= 100 && !snake.canFly()){
                System.out.println("Now you can fly");
                snake = new FlaybleCharacter(snake);
            }
            if (snake.getExp() >= 200 && !snake.canSpeak()){
                System.out.println("Now you can speak");
                snake = new SpeakableCharacter(snake);
            }

        }

    }
}

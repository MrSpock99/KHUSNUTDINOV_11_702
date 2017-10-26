package ru.itis;

public class Main {

    public static void main(String[] args) {
	// write your code here

        TV tv = TV.getInstance();

        TV tv2 = TV.getInstance();

        tv2.setX(2);

        Remote.Builder remote = Remote.builder()
                .name("Remote 1")
                .firmName("Samsung")
                .lifeTime("01.02.2017 02.01.2100")
                .serialNum(10101)
                .tv(tv)
                .manufacturer("Samsung remote inc.");

        remote.switchToChannel("Второй канал");



    }
}

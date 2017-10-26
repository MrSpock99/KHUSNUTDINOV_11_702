package ru.itis;

import java.time.LocalTime;

public class TV {
    private Channel[] channels;
    int x;
    private static final TV instance;

    static {
        instance = new TV();
    }

    public void setX(int x) {
        this.x = x;
    }

    private TV(){
        channels = new Channel[10];
        fillChannels();
    }

    private void fillChannels() {
        channels[0] = new Channel("Первый канал",new TVShow(generateTVShowName(),LocalTime.parse("00:00:00"),LocalTime.parse("01:00:00")),new TVShow(generateTVShowName(),LocalTime.parse("01:00:00"),LocalTime.parse("02:00:00")),new TVShow(generateTVShowName(),LocalTime.parse("02:00:00"),LocalTime.parse("03:00:00")),new TVShow(generateTVShowName(),LocalTime.parse("03:00:00"),LocalTime.parse("04:00:00")));
        channels[1] = new Channel("Второй канал",new TVShow(generateTVShowName(),LocalTime.parse("07:00:00"),LocalTime.parse("09:00:00")),new TVShow(generateTVShowName(),LocalTime.parse("09:00:00"),LocalTime.parse("16:00:00")),new TVShow(generateTVShowName(),LocalTime.parse("02:00:00"),LocalTime.parse("03:00:00")),new TVShow(generateTVShowName(),LocalTime.parse("03:00:00"),LocalTime.parse("04:00:00")));
        channels[2] = new Channel("Третий канал",new TVShow(generateTVShowName(),LocalTime.parse("00:00:00"),LocalTime.parse("02:00:00")),new TVShow(generateTVShowName(),LocalTime.parse("01:00:00"),LocalTime.parse("02:00:00")),new TVShow(generateTVShowName(),LocalTime.parse("02:00:00"),LocalTime.parse("03:00:00")),new TVShow(generateTVShowName(),LocalTime.parse("03:00:00"),LocalTime.parse("04:00:00")));
        channels[3] = new Channel("Четвертый канал",new TVShow(generateTVShowName(),LocalTime.parse("00:00:00"),LocalTime.parse("02:00:00")),new TVShow(generateTVShowName(),LocalTime.parse("01:00:00"),LocalTime.parse("02:00:00")),new TVShow(generateTVShowName(),LocalTime.parse("02:00:00"),LocalTime.parse("03:00:00")),new TVShow(generateTVShowName(),LocalTime.parse("03:00:00"),LocalTime.parse("04:00:00")));
        channels[4] = new Channel("Пятый канал",new TVShow(generateTVShowName(),LocalTime.parse("00:00:00"),LocalTime.parse("02:00:00")),new TVShow(generateTVShowName(),LocalTime.parse("01:00:00"),LocalTime.parse("02:00:00")),new TVShow(generateTVShowName(),LocalTime.parse("02:00:00"),LocalTime.parse("03:00:00")),new TVShow(generateTVShowName(),LocalTime.parse("03:00:00"),LocalTime.parse("04:00:00")));
        channels[5] = new Channel("Шестой канал",new TVShow(generateTVShowName(),LocalTime.parse("00:00:00"),LocalTime.parse("02:00:00")),new TVShow(generateTVShowName(),LocalTime.parse("01:00:00"),LocalTime.parse("02:00:00")),new TVShow(generateTVShowName(),LocalTime.parse("02:00:00"),LocalTime.parse("03:00:00")),new TVShow(generateTVShowName(),LocalTime.parse("03:00:00"),LocalTime.parse("04:00:00")));
        channels[6] = new Channel("Седьмой канал",new TVShow(generateTVShowName(),LocalTime.parse("00:00:00"),LocalTime.parse("02:00:00")),new TVShow(generateTVShowName(),LocalTime.parse("01:00:00"),LocalTime.parse("02:00:00")),new TVShow(generateTVShowName(),LocalTime.parse("02:00:00"),LocalTime.parse("03:00:00")),new TVShow(generateTVShowName(),LocalTime.parse("03:00:00"),LocalTime.parse("04:00:00")));
        channels[7] = new Channel("Восьмой канал",new TVShow(generateTVShowName(),LocalTime.parse("00:00:00"),LocalTime.parse("02:00:00")),new TVShow(generateTVShowName(),LocalTime.parse("01:00:00"),LocalTime.parse("02:00:00")),new TVShow(generateTVShowName(),LocalTime.parse("02:00:00"),LocalTime.parse("03:00:00")),new TVShow(generateTVShowName(),LocalTime.parse("03:00:00"),LocalTime.parse("04:00:00")));
        channels[8] = new Channel("Девятый канал",new TVShow(generateTVShowName(),LocalTime.parse("00:00:00"),LocalTime.parse("02:00:00")),new TVShow(generateTVShowName(),LocalTime.parse("01:00:00"),LocalTime.parse("02:00:00")),new TVShow(generateTVShowName(),LocalTime.parse("02:00:00"),LocalTime.parse("03:00:00")),new TVShow(generateTVShowName(),LocalTime.parse("03:00:00"),LocalTime.parse("04:00:00")));
        channels[9] = new Channel("Десятый канал",new TVShow(generateTVShowName(),LocalTime.parse("00:00:00"),LocalTime.parse("02:00:00")),new TVShow(generateTVShowName(),LocalTime.parse("01:00:00"),LocalTime.parse("02:00:00")),new TVShow(generateTVShowName(),LocalTime.parse("07:00:00"),LocalTime.parse("08:00:00")),new TVShow(generateTVShowName(),LocalTime.parse("03:00:00"),LocalTime.parse("04:00:00")));
    }



    private String generateTVShowName() {
        String [] wordListOne = {"Хороший", "Плохой",
                "Диванный", "Новостной","Путинский" };
        String [] wordListTwo = {"Вечер", "Навальный", "Путин"} ;
        String [] wordListThree = {"На диване","На красной площади", "Без цензуры", "Для детей", "Для взрослых","Для бабушек"};
        int oneLength = wordListOne.length;
        int twoLength = wordListTwo.length;
        int threeLength = wordListThree.length;

        int rand1 = (int) (Math.random() * oneLength);
        int rand2 = (int) (Math.random() * twoLength);
        int rand3 = (int) (Math.random() * threeLength);

        return wordListOne[rand1] + " " + wordListTwo[rand2]
                + " " + wordListThree[rand3];
    }

    public static TV getInstance() {
        return instance;
    }

    public void show(Channel channel){
        System.out.println("По каналу '" + channel.getName() + "' идет передача '" + channel.getCurrentTVShow() + "'");
    }

    public Channel[] getChannels() {
        return channels;
    }


    public void switchChannel(String name) {
        for (Channel channel : channels) {
            if (channel.getName().equals(name)) {
                show(channel);
                break;
            }
        }

    }
}

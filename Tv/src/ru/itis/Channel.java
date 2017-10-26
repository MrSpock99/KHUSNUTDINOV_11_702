package ru.itis;

import java.time.LocalTime;

public class Channel{

    private String name;
    private TVShow[] tvShows;

    public Channel(String name, TVShow show1, TVShow show2, TVShow show3, TVShow show4){
        this.name = name;
        tvShows = new TVShow[]{show1, show2, show3, show4};

    }


    public String getCurrentTVShow() {
        String res = "There is no any TV shows at the moment";
        for (TVShow show : tvShows){
            if (LocalTime.now().isAfter(show.getBeginTime()) && LocalTime.now().isBefore(show.getEndTime())){
                res = show.getName();
            }
        }

        return res;
    }

    public String getName() {
        return name;
    }
}

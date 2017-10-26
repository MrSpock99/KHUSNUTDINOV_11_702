package ru.itis;

import java.time.LocalTime;

public class TVShow{
    private String name;
    private LocalTime beginTime;
    private LocalTime endTime;

    public TVShow(String name, LocalTime beginTime, LocalTime endTime){
        this.name = name;
        this.beginTime = beginTime;
        this.endTime = endTime;

    }

    public LocalTime getBeginTime() {
        return beginTime;
    }



    public LocalTime getEndTime() {
        return endTime;
    }


    public String getName() {
        return name;
    }


}
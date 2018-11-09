package patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class Internet implements Observable{
    private List<Observer> observerList;
    private String trend;

    public Internet(){
        observerList = new ArrayList<>();
    }


    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observerList){
            observer.handle(trend);
        }
    }

    public void makeTrend(String trend){
        this.trend = trend;
        notifyObserver();
    }
    
}

package p6;

public class Snake extends Character{
    void crawl(){
        System.out.println("Crawling");
    }

    @Override
    public boolean canFly() {
        return false;
    }

    @Override
    public boolean canSpeak() {
        return false;
    }
}

package patterns.composite;

import java.util.List;

public class Panel implements Window {
    private List<Window> components;

    public Panel(List<Window> components){
        this.components = components;
    }
    @Override
    public void draw() {
        for (Window component : components){
            component.draw();
        }
    }

    public void add(Window window){
        components.add(window);
    }

    public void remove(Window window){
        components.remove(window);
    }
}

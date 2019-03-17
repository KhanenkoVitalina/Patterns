import java.util.ArrayList;
import java.util.List;

public class CompositePattern {
    public static void main(String[] args) {
        Component component = new Button();
        Component component1 = new Link();

        Composite composite = new Composite();
        composite.addComponent(component);
        composite.addComponent(component1);
        composite.draw();
    }
}
interface Component{
    void draw();
}
class Button implements Component{

    @Override
    public void draw() {
        System.out.println("Draw button");
    }
}
class TextField implements Component{

    @Override
    public void draw() {
        System.out.println("Draw textfield");
    }
}
class Link implements Component{

    @Override
    public void draw() {
        System.out.println("Draw link");
    }
}
class Composite implements Component{
    private List<Component> componentList = new ArrayList<>();
    @Override
    public void draw() {
        componentList.stream().forEach(Component::draw);
    }
    public void addComponent(Component component){
        componentList.add(component);
    }
    public void removeComponent(Component component){
        componentList.remove(component);
    }

}


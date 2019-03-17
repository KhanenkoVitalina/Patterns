import java.util.ArrayList;
import java.util.List;

public class OberverPattern {
    public static void main(String[] args) {
        MeteoBroadcast meteoBroadcast = new MeteoBroadcast();
        meteoBroadcast.addObserver(new ConsoleObserver());
        meteoBroadcast.setMeasurament(12, 344);
    }

}
interface Observable{
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
interface Observer{
    void handleEvent(int temperature, int pressure);
}
class ConsoleObserver implements Observer{

    @Override
    public void handleEvent(int temperature, int pressure) {
        System.out.println("Weather has changed: " + temperature + " " + pressure);
    }
}

class MeteoBroadcast implements Observable{
    private int temperature;
    private int pressure;
    private List<Observer> observerList = new ArrayList<>();
    void setMeasurament(int temperature, int pressure){
        this.temperature = temperature;
        this.pressure = pressure;
        notifyObservers();
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
    public void notifyObservers() {
        for(Observer observer: observerList){
            observer.handleEvent(temperature, pressure);
        }
    }
}

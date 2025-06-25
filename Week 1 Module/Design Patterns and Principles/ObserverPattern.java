import java.util.*;

interface Observer {
    void update(String stock, double price);
}

interface Subject {
    void register(Observer o);
    void notifyObservers();
}

class StockMarket implements Subject {
    private String stock;
    private double price;
    private List<Observer> obs = new ArrayList<>();

    public StockMarket(String s, double p) {
        stock = s;
        price = p;
    }

    public void register(Observer o) {
        obs.add(o);
    }

    public void changePrice(double p) {
        price = p;
        notifyObservers();
    }

    public void notifyObservers() {
        for (Observer o : obs) {
            o.update(stock, price);
        }
    }
}

class MobileApp implements Observer {
    public void update(String s, double p) {
        System.out.println("Mobile App - " + s + ": " + p);
    }
}

class ObserverTest {
    public static void main(String[] args) {
        StockMarket m = new StockMarket("AAPL", 150);
        m.register(new MobileApp());
        m.changePrice(160);
    }
}

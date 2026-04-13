package subject;

import observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class Stock implements Subject {
    private String symbol;
    private double price;
    private List<Observer> investors = new ArrayList<>();

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }

    @Override
    public void attach(Observer o) {
        investors.add(o);
    }

    @Override
    public void detach(Observer o) {
        investors.remove(o);
    }

    @Override
    public void notifyObservers() {
        String message = "Stock " + symbol + " new price: " + price;
        for (Observer investor : investors) {
            investor.update(message);
        }
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }
}
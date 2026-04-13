interface Coffee {
    int cost();
}

class BasicCoffee implements Coffee {
    @Override
    public int cost() {
        return 20000;
    }
}

abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }
}

class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public int cost() {
        return coffee.cost() + 5000;
    }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public int cost() {
        return coffee.cost() + 2000;
    }
}

public class DecoratorMain {
    public static void main(String[] args) {
        Coffee coffee = new BasicCoffee();
        System.out.println("Giá cà phê cơ bản: " + coffee.cost());

        coffee = new MilkDecorator(coffee);
        System.out.println("Thêm sữa: " + coffee.cost());

        coffee = new SugarDecorator(coffee);
        System.out.println("Thêm đường: " + coffee.cost());
    }
}
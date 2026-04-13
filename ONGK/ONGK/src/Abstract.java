interface Button {
    void paint();
}

interface Checkbox {
    void paint();
}

class WindowsButton implements Button {
    @Override
    public void paint() {
        System.out.println("Vẽ Windows Button");
    }
}

class MacButton implements Button {
    @Override
    public void paint() {
        System.out.println("Vẽ Mac Button");
    }
}

class WindowsCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Vẽ Windows Checkbox");
    }
}

class MacCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Vẽ Mac Checkbox");
    }
}

interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

class MacFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

public class AbstractFactoryMain {
    public static void main(String[] args) {
        GUIFactory factory = new WindowsFactory();
        Button b = factory.createButton();
        Checkbox c = factory.createCheckbox();
        b.paint();
        c.paint();

        factory = new MacFactory();
        b = factory.createButton();
        c = factory.createCheckbox();
        b.paint();
        c.paint();
    }
}
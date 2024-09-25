interface F1Car {
    void display();
}

class FerrariF1Car implements F1Car {
    public void display() {
        System.out.println("Ferrari F1 Car");
    }
}

class MercedesF1Car implements F1Car {
    public void display() {
        System.out.println("Mercedes F1 Car");
    }
}

abstract class F1CarFactory {
    abstract F1Car createCar();
}

class FerrariFactory extends F1CarFactory {
    F1Car createCar() {
        return new FerrariF1Car();
    }
}

class MercedesFactory extends F1CarFactory {
    F1Car createCar() {
        return new MercedesF1Car();
    }
}

public class factorydp {
    public static void main(String args[]) {
        F1CarFactory ferrariFactory = new FerrariFactory();
        F1Car ferrari = ferrariFactory.createCar();
        ferrari.display();

        F1CarFactory mercedesFactory = new MercedesFactory();
        F1Car mercedes = mercedesFactory.createCar();
        mercedes.display();
    }
}
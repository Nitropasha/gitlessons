package inner_class;

public class Car {
    String color;
    int doorCount;
    Engine engine;

    public Car(String color, int doorCount) {
        this.color = color;
        this.doorCount = doorCount;
//        this.engine = this.new Engine(horsePower);
    }
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "My Car{" +
                "color='" + color + '\'' +
                ", doorCount=" + doorCount +
                ", engine=" + engine +
                '}';
    }

    public class Engine {
        int horsePower;

        public Engine(int horsePower) {
            this.horsePower = horsePower;
        }

        @Override
        public String toString() {
            return "My Engine{" +
                    "horsePower=" + horsePower +
                    '}';
        }
    }
}

class  Test {
    public static void main(String[] args) {
//        Car.Engine e = new Car.Engine(256);
        Car car = new Car("black", 4);
        Car.Engine engine = car.new Engine(150);
        car.setEngine(engine);
        System.out.println(car);
        Car.Engine engine3 = new Car("yellow", 4).new Engine(200);

//        Car.Engine engine2 = new Car.Engine(150); - так нельзя

    }
}
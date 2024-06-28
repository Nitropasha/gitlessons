package lamda;
@FunctionalInterface
interface Generator {
    int getNextElement();
}
interface Generator2 {
    public int getNextElement2(IntGenerator gen);
}

class IntGenerator {
    public int next() {
        return 3;
    }
}

class SimpleGen {
    private int number;

    public SimpleGen(int number) {
        super();
        this.number = number;
    }

    public SimpleGen() {
        super();
    }

    public int getNumber() {
        int temp = number;
        number = number +1;
        return temp;
    }
    public static int getRandomNumber() {
        return (int) (Math.random() * 10);
    }
}

public class Links2 {
    public static void main(String[] args) {

        // Ссылка на не статический метод кокретного объекта
        SimpleGen sg = new SimpleGen(5);
        Generator gen1 = sg::getNumber;
        int temp = gen1.getNextElement();
        int temp2 = gen1.getNextElement();
        System.out.println(temp2);

        // Ссылка на статический метод класса
        Generator gen2 = SimpleGen::getRandomNumber;
        int temp3 = gen2.getNextElement();
        System.out.println(temp3);

        // Ссылка на не статический метод любого объекта

        Generator2 generator2 = IntGenerator::next;
        IntGenerator a = new IntGenerator();
        System.out.println(generator2.getNextElement2(a));

        // Ссылка на конструктор



    }

}

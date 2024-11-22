package anonymous_class;
public class AccessExample {
    int instanceField = 10;// Поле экземпляра
    private static int staticField = 20; // Статическое поле

    @Override
    public String toString() {
        return "AccessExample3{" +
                "instanceField=" + instanceField +
                '}';
    }

    public void demonstrateAccess(int param) {
       // int localVar = 30; // Локальная переменная
        int localVar = 40; // Если раскомментировать, будет ошибка компиляции, потому что localVar не эффективно финальная

        // Лямбда-выражение
        Runnable lambda = () -> {
            // Доступ к полям и переменным
            System.out.println("Лямбда-выражение:");
            System.out.println("instanceField: " + instanceField); // доступ к полю экземпляра
            System.out.println("staticField: " + staticField); // доступ к статическому полю
            System.out.println("param: " + param); // доступ к параметру метода
            System.out.println("localVar: " + localVar); // доступ к локальной переменной

            // Демонстрация использования this
            System.out.println("this в лямбда: " +  this); // Ссылается на внешнюю область видимости (экземпляр AccessExample)
        };

        // Анонимный класс
        Runnable anonClass = new Runnable() {
            @Override
            public void run() {
                // Доступ к полям и переменным

                System.out.println("Анонимный класс:");
                System.out.println("instanceField: " + instanceField); // доступ к полю экземпляра
                System.out.println("staticField: " + staticField); // доступ к статическому полю
                System.out.println("param: " + param); // доступ к параметру метода
                System.out.println("localVar: " + localVar); // доступ к локальной переменной

                // Демонстрация использования this
                System.out.println("this в анонимном классе: " + this); // Ссылается на экземпляр анонимного класса
            }

        };

        lambda.run();
        anonClass.run();
    }

    public static void main(String[] args) {
        new AccessExample().demonstrateAccess(40);
    }
}
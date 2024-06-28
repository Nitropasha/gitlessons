package anonymous_class;

public class AnonymousClass {
    public static void main(String[] args) {
        Math m = new Math() {
            int c = 10;
            @Override
            public int doOperation(int a, int b) {
                return a+b;
            }
        };
        Math2 m2 = new Math2() {
            int c = 10;
            @Override
            public int doOperation(int a, int b) {
                return a*b;
            }
        };
        System.out.println(m.doOperation(3,4));
        System.out.println(m2.doOperation(3,4));
    }
}

interface Math{
    int doOperation(int a, int b);
}
class Math2{
    int doOperation(int a, int b) {
        return a/b;
    }
}
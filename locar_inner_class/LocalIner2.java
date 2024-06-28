package locar_inner_class;

public class LocalIner2 {
    public static void main(String[] args) {
        class Slojenie implements Math2 {
            public int doOperation(int a, int b) {
                return a+b;
            }

        }
        Slojenie s = new Slojenie();
        System.out.println(s.doOperation(5,5));
    }
}
interface Math2 {
    int doOperation(int a, int b);
}
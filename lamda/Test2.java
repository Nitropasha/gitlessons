package lamda;
import java.util.function.UnaryOperator;

public class Test2 {

    static public UnaryOperator<Integer> sqrt(){
        //Твой код здесь

        return x -> x * x;
    }

    public static void main(String[] args) {


        System.out.println(sqrt().apply(4));
    }
//    static void def (I i) {
//        System.out.println(i.abc("Privet"));
//    }
//
//    public static void main(String[] args) {
//        def((String s) -> {
//            return s.length();
//        });
//    }

}
//
//interface  I {
//    int abc(String s);
//        }





//public interface UnaryOperator<T> {
//    T apply(T t);
//}
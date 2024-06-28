package lamda;

interface Modifier <T> {
    public T change(T obj);
}
@FunctionalInterface
interface IntElementGen {
    public Integer next(Integer current);
}

class Gen {
    public <T> T nextElement(T current) {
        return current;
    }
}
class  MySuperNumberGenerator {

    public Integer add(Integer n) {
        return n+10;
    }

    public Double add(Double n) {
        return n+10.0;
    }

    public String add(String n) {
        return n + " " + n;
    }

}

public class ObobshenieFuncInterface {
    public static void main(String[] args) {
        MySuperNumberGenerator ng = new MySuperNumberGenerator();
        Modifier<Integer> a = ng::add;
        Modifier<String> b = ng::add;
     }
}

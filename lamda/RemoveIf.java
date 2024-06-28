package lamda;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class RemoveIf {
    public static void main(String[] args) {
        ArrayList<String> a1 = new ArrayList<>();
        a1.add("Privet");
        a1.add("Пока");
        a1.add("мы");
        a1.add("Учим Java");
        a1.add("супер пупер");
        a1.add("успешно!");
        UnaryOperator<String> s1 = element -> element.replaceFirst("Java", "Хуява");
        UnaryOperator<String> s2 = element -> element.replaceFirst("супер", "хуюпер");
        a1.replaceAll(s1);
        a1.replaceAll(s2);
        System.out.println(a1);
        Predicate<String> p1 = element -> element.length()<3;
        Predicate<String> p2 = element -> element.equalsIgnoreCase("УСпешнО!");
        a1.removeIf(p1.or(p2));
        System.out.println(a1);
    }
}

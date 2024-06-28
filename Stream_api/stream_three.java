package Stream_api;

import java.util.Arrays;
import java.util.stream.Stream;

public class stream_three {
    public static void main(String[] args) {
        int[] array = {5, 9, 3, 8, 1};
        Arrays.stream(array).forEach(e1 -> {
            e1 *= 2;
            System.out.print(e1 + " , ");
        });
        Arrays.stream(array).forEach(System.out::print);
        System.out.println("А теперьь ссылкой");
        Arrays.stream(array).forEach(Utils::myMethod);
        Arrays.stream(array).forEach(e1 -> Utils.myMethod(e1));
        Stream<String> stream = Stream.of("один", "два", "три");

        stream.forEach(System.out::println); // Это терминальная операция.


    }
}

class Utils {
    public static void myMethod(int a) {
        a=a+5;
        System.out.println("Элемент - " + a);

    }
}
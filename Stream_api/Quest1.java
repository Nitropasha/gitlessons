package Stream_api;
import javax.xml.transform.Result;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Quest1 {
    public static void main(String[] args) {
//        Stream<String> stream = Stream.of("1", "2", "3", "1", "-78", "678");
//        findMinMax(stream, String::compareTo, (a, b) -> System.out.println(a + " и " + b));

        Stream<Integer> stream = Stream.of(123, 54325, 456, 567, 768, 7689, 78, 35, 132);
        Comparator<? super Integer> comparator = Integer::compare;
        BiConsumer<? super Integer, ? super Integer> biConsumer = (x1, x2) -> System.out.println("min: " + x1 + "\nmax: " + x2);
        findMinMax(stream, comparator, biConsumer);
    }

static public <T> void findMinMax(
        Stream<? extends T> stream,
        Comparator<? super T> order,
        BiConsumer<? super T, ? super T> minMaxConsumer) {
        stream.collect(Collectors.teeing(
            Collectors.minBy(order),
            Collectors.maxBy(order),
            (min, max) ->  {
                minMaxConsumer.accept(min.orElse(null), max.orElse(null));
                return null;
            }
    ));
}
}
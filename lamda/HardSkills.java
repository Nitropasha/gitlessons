package lamda;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public class HardSkills {
    public static void main(String[] args) {

        Predicate<Object> condition = Objects::isNull;
        Function<Object, Integer> ifTrue = obj -> 0;
        Function<CharSequence, Integer> ifFalse = CharSequence::length;
        Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue, ifFalse);
        // по сути вместо написания статического метода можно было сделать так - >
//      Function<String, Integer> safeStringLength = x -> condition.test(x) ? ifTrue.apply(x) : ifFalse.apply(x);
        System.out.println(safeStringLength.apply("MyBestJob"));

    }

static public <T, U> Function<T, U> ternaryOperator(
        Predicate<? super T> condition,
        Function<? super T, ? extends U> ifTrue,
        Function<? super T, ? extends U> ifFalse) {
        return x -> condition.test(x) ? ifTrue.apply(x) : ifFalse.apply(x);
}

}

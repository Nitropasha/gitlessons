package Stream_api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class stream_4_reduce {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(1);
        list.add(6);
        list.add(9);
        list.add(2);
        list.add(7);
        int res = list.stream().reduce((acumulator, element) ->
                acumulator+element).get();
        System.out.println(res);
        // acumulator = 5
        // element = 1
        // а в случае ниже метод гет не нужен тк мы задали 1-у в качестве начального значения аккумулятора
        System.out.println(" - - - - - ");
        int res2 = list.stream().reduce(1, (acumulator, element) ->
                acumulator+element);
        System.out.println(res2);

        int sum = list.stream().reduce(0, Integer::sum);
        System.out.println(sum);

        List<Integer> list2 = new ArrayList<>();
        Optional<Integer> res3 = list2.stream().reduce((acumulator, element) ->
                acumulator+element);
        if (res3.isPresent()) {
            System.out.println(res3.get());
        }
        else {
            System.out.println("Not present");
        }
    }
}

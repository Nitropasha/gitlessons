package Stream_api;

import java.util.*;
import java.util.stream.Collectors;

public class stream_one {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("How are you?");
        list.add("Good!");
        list.add("Super");
        list.add("Good bey");
// Старый способ
//        for (int i = 0; i < list.size(); i++) {
//            list.set(i, String.valueOf(String.valueOf(list.get(i).length())));
//        }
        // теперь у нас вместо Hello - 5 и тд
        List <Integer> list2 = list.stream().map(element -> element.length())
                        .collect(Collectors.toList());


        System.out.println(list2);

        int[] array = {5, 9, 3, 8, 1};
        array = Arrays.stream(array).map(element
        -> {if (element%3==0){
        element = element/3;}
            return element;
        }).toArray();
        System.out.println(Arrays.toString(array));

        Set<String> set = new TreeSet<>();
        set.add("Hello");
        set.add("How are you?");
        set.add("Good!!!");
        set.add("Super!");
        set.add("Good bey");
        System.out.println(set);

        Set<Integer> set2 = set.stream().map(e -> e.length()).collect(Collectors.toSet());
        List<Integer> list3 = set.stream().map(e -> e.length()).collect(Collectors.toList());
        System.out.println(set2);
        System.out.println(list3);



    }
}

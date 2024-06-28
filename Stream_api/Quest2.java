package Stream_api;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Quest2 {
public static void main(String[] args) {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    reader.lines()
            .flatMap(Pattern.compile("(?U)[^\\p{L}\\p{Digit}]+")::splitAsStream)
            .filter(token -> !token.isEmpty())
            .map(String::toLowerCase)
            .collect(Collectors.toMap(word -> word, word -> 1, Integer::sum))
            .entrySet()
            .stream()
            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                    .thenComparing(Map.Entry.comparingByKey()))
            .limit(10)

//            .map(Map.Entry::getKey)
//            .forEach(System.out::println);
            .forEach(x -> System.out.println(x.getKey()));
}
}
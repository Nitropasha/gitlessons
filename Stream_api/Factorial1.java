package Stream_api;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class Factorial1 {
    public static void main(String[] args) {
        int value = 2;
        BigInteger result = factorial(value);
        System.out.println("Factorial of " + value + ": " + result);
    }


public static BigInteger factorial(int value) {
// Твой код здесь
    if (value <= 1) {
        return BigInteger.valueOf(1);
    } else {
        return IntStream.rangeClosed(2, value).mapToObj(BigInteger::valueOf).reduce(BigInteger::multiply).get();
    }
}



}

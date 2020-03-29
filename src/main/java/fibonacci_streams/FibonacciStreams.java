package fibonacci_streams;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FibonacciStreams {
    public static void main(String[] args) {
        BigInteger[] fibonacciSeries = fibonacciSeriesGenerator();
        for (int i = 0, n = fibonacciSeries.length; i < n; i++) {
            System.out.println("position number: " + (i + 1) + " Fibonacci number: " + fibonacciSeries[i]);
        }
    }

    private static BigInteger[] fibonacciSeriesGenerator() {
        BigInteger[] arrayInteger = new BigInteger[0];
        return Stream.iterate(new BigInteger[]{BigInteger.ZERO, BigInteger.ONE},
                                t -> new BigInteger[]{t[1], t[0].add(t[1])})
                .limit(100)
                .map(t -> t[0])
                .collect(Collectors.toList())
                .toArray(arrayInteger);
    }
}



package Functional;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntToDoubleFunction;

public class LambdaExamples {
    IntToDoubleFunction incrementalCosts = time -> 5.1 + 0.15 * time;

    Function<String, Integer> wordCount = s -> s.split(" ").length;

    BiFunction<String, Integer, Boolean> exceedsMaxLength = (s, maxLength) -> {
        int actualLength = s.length();
        return actualLength > maxLength;
    };
}

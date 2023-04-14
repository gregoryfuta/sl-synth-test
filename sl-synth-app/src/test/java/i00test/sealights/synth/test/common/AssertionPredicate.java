package i00test.sealights.synth.test.common;

import java.util.function.Predicate;

public class AssertionPredicate {
    public static Predicate<String> predicateForInput(final String input) {
        return response -> response.endsWith(input)
            && response.startsWith("OUTPUT: ");
    }
}

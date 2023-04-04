package i00test.sealights.synth.test.sync;

import i0.sealights.synth.common.module000.api.Controller000;
import i0.sealights.synth.common.module000.service.Service000;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;


public class SyncTestB {

    @Test
    void testSync000() {
        Service000 service = new Service000();
        Controller000 controller = new Controller000(service);

        IntStream.range(1, 50).parallel().forEach(intValue -> {
                final String input = String.format("%03d", intValue);
                StepVerifier
                    .create(controller.ctrlMethod000(input))
                    .expectNextMatches(predicateForInput(input))
                    .expectComplete()
                    .verify();
            }
        );
    }

    @Test
    void testSync001() {
        Service000 service = new Service000();
        Controller000 controller = new Controller000(service);

        IntStream.range(1, 50).forEach(intValue -> {
                final String input = String.format("%03d", intValue);
                StepVerifier
                    .create(controller.ctrlMethod001(input))
                    .expectNextMatches(predicateForInput(input))
                    .expectComplete()
                    .verify();
            }
        );
    }

    private static Predicate<String> predicateForInput(final String input) {
        System.out.println("VERIFICATION: " + input);
        return response -> response.endsWith(input)
            && response.startsWith("OUTPUT: ");
    }

}

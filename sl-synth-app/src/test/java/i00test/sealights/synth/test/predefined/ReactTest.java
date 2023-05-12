package i00test.sealights.synth.test.predefined;

import static i00test.sealights.synth.test.common.AssertionPredicate.predicateForInput;
import static org.junit.jupiter.api.Assertions.assertEquals;

import gen.i0.sealights.synth.app.module000.api.Controller000;
import gen.i0.sealights.synth.app.module000.api.Controller001;
import gen.i0.sealights.synth.app.module000.service.Service000;
import gen.i0.sealights.synth.app.module000.service.Service001;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;
import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;
import reactor.test.StepVerifier;

public class ReactTest {

  @Test
  void monoTest() {
    System.out.println("Start... ");
    Service000 service = new Service000();
    Controller000 controller = new Controller000(service);

    List<String> results = new ArrayList<>();

//    IntStream.range(1, 2)
//        .forEach(
//            intValue -> {
//              final String input = String.format("%03d", intValue);
//              final String actual = controller.ctrlSyncMethod000(input);
//              results.add(actual);
//              assertEquals("OUTPUT: " + input, actual);
//            });

    IntStream.range(1, 20)
        .parallel()
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              System.out.println("XXX before resolve: " + input);
              StepVerifier.create(controller.ctrlAsyncMethod000(input))
                  .expectNextMatches(predicateForInput(input))
                  .expectComplete()
                  .verify();
              System.out.println("XXX after resolve: " + input);
            });

    System.out.println("... results ...");

    System.out.println(results);

    System.out.println("... end");
  }
}

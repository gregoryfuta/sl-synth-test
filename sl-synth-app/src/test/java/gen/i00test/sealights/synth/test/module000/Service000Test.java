package gen.i00test.sealights.synth.test.module000;

import static i00test.sealights.synth.test.common.AssertionPredicate.predicateForInput;
import static org.junit.jupiter.api.Assertions.assertEquals;
    
import gen.i0.sealights.synth.app.module000.api.Controller000;
import gen.i0.sealights.synth.app.module000.service.Service000;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

@DisplayName("Service000Test")
public class Service000Test {

  @Test
  void testAsync000() {
    Service000 service = new Service000();
    Controller000 controller = new Controller000(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              StepVerifier.create(controller.ctrlAsyncMethod000(input))
                  .expectNextMatches(predicateForInput(input))
                  .expectComplete()
                  .verify();
            });
  }
    
  @Test
  void testSync000() {
    Service000 service = new Service000();
    Controller000 controller = new Controller000(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              final String actual = controller.ctrlSyncMethod000(input);
              assertEquals("OUTPUT: " + input, actual);
            });
  }
  @Test
  void testAsync001() {
    Service000 service = new Service000();
    Controller000 controller = new Controller000(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              StepVerifier.create(controller.ctrlAsyncMethod001(input))
                  .expectNextMatches(predicateForInput(input))
                  .expectComplete()
                  .verify();
            });
  }
    
  @Test
  void testSync001() {
    Service000 service = new Service000();
    Controller000 controller = new Controller000(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              final String actual = controller.ctrlSyncMethod001(input);
              assertEquals("OUTPUT: " + input, actual);
            });
  }

}
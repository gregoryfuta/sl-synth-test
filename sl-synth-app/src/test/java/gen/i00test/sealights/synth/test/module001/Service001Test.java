package gen.i00test.sealights.synth.test.module001;

import static i00test.sealights.synth.test.common.AssertionPredicate.predicateForInput;

import gen.i0.sealights.synth.app.module001.api.Controller001;
import gen.i0.sealights.synth.app.module001.service.Service001;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

@DisplayName("Service001Test")
public class Service001Test {

  @Test
  void testSync000() {
    Service001 service = new Service001();
    Controller001 controller = new Controller001(service);

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
  void testSync001() {
    Service001 service = new Service001();
    Controller001 controller = new Controller001(service);

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
}
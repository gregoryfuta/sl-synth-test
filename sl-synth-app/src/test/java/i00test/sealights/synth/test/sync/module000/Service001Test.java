package i00test.sealights.synth.test.sync.module000;

import static i00test.sealights.synth.test.common.AssertionPredicate.predicateForInput;

import gen.i0.sealights.synth.app.module000.api.Controller001;
import gen.i0.sealights.synth.app.module000.service.Service001;
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

    IntStream.range(1, 50)
        .parallel()
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              StepVerifier.create(controller.ctrlMethod000(input))
                  .expectNextMatches(predicateForInput(input))
                  .expectComplete()
                  .verify();
            });
  }

  @Test
  void testSync001() {
    Service001 service = new Service001();
    Controller001 controller = new Controller001(service);

    IntStream.range(1, 50)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              StepVerifier.create(controller.ctrlMethod001(input))
                  .expectNextMatches(predicateForInput(input))
                  .expectComplete()
                  .verify();
            });
  }
}

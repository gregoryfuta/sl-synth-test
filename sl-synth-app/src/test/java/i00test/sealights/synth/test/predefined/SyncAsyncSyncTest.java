package i00test.sealights.synth.test.predefined;

import static i00test.sealights.synth.test.common.AssertionPredicate.predicateForInput;

import gen.i0.sealights.synth.app.module000.api.Controller000;
import gen.i0.sealights.synth.app.module000.api.Controller001;
import gen.i0.sealights.synth.app.module000.service.Service000;
import gen.i0.sealights.synth.app.module000.service.Service001;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

@DisplayName("SyncAsyncSyncTest")
public class SyncAsyncSyncTest {

  @Test
  void testAsync() {
    Service000 service = new Service000();
    Controller000 controller = new Controller000(service);

    IntStream.range(1, 50)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              final String actual = controller.ctrlSyncMethod000(input);
              Assertions.assertEquals("OUTPUTx: " + input, actual);
            });

    IntStream.range(1, 2)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              StepVerifier.create(controller.ctrlAsyncMethod000(input))
                  .expectNextMatches(predicateForInput(input))
                  .expectComplete()
                  .verify();
            });

    IntStream.range(1, 50)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              final String actual = controller.ctrlSyncMethod001(input);
              Assertions.assertEquals("OUTPUTx: " + input, actual);
            });
  }

    @Test
    void testAsync001() {
        Service001 service = new Service001();
        Controller001 controller = new Controller001(service);

        IntStream.range(1, 50)
            .forEach(
                intValue -> {
                    final String input = String.format("%03d", intValue);
                    final String actual = controller.ctrlSyncMethod000(input);
                    Assertions.assertEquals("OUTPUT: " + input, actual);
                });

        IntStream.range(1, 2)
            .forEach(
                intValue -> {
                    final String input = String.format("%03d", intValue);
                    StepVerifier.create(controller.ctrlAsyncMethod000(input))
                        .expectNextMatches(predicateForInput(input))
                        .expectComplete()
                        .verify();
                });

        IntStream.range(1, 50)
            .forEach(
                intValue -> {
                    final String input = String.format("%03d", intValue);
                    final String actual = controller.ctrlSyncMethod001(input);
                    Assertions.assertEquals("OUTPUT: " + input, actual);
                });
    }
}

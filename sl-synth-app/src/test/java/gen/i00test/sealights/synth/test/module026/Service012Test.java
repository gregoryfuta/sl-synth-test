package gen.i00test.sealights.synth.test.module026;

import static i00test.sealights.synth.test.common.AssertionPredicate.predicateForInput;
import static org.junit.jupiter.api.Assertions.assertEquals;
    
import gen.i0.sealights.synth.app.module026.api.Controller012;
import gen.i0.sealights.synth.app.module026.service.Service012;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

@DisplayName("Service012Test")
public class Service012Test {

  @Test
  void testAsync000() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

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
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

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
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

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
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              final String actual = controller.ctrlSyncMethod001(input);
              assertEquals("OUTPUT: " + input, actual);
            });
  }
  @Test
  void testAsync002() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              StepVerifier.create(controller.ctrlAsyncMethod002(input))
                  .expectNextMatches(predicateForInput(input))
                  .expectComplete()
                  .verify();
            });
  }
    
  @Test
  void testSync002() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              final String actual = controller.ctrlSyncMethod002(input);
              assertEquals("OUTPUT: " + input, actual);
            });
  }
  @Test
  void testAsync003() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              StepVerifier.create(controller.ctrlAsyncMethod003(input))
                  .expectNextMatches(predicateForInput(input))
                  .expectComplete()
                  .verify();
            });
  }
    
  @Test
  void testSync003() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              final String actual = controller.ctrlSyncMethod003(input);
              assertEquals("OUTPUT: " + input, actual);
            });
  }
  @Test
  void testAsync004() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              StepVerifier.create(controller.ctrlAsyncMethod004(input))
                  .expectNextMatches(predicateForInput(input))
                  .expectComplete()
                  .verify();
            });
  }
    
  @Test
  void testSync004() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              final String actual = controller.ctrlSyncMethod004(input);
              assertEquals("OUTPUT: " + input, actual);
            });
  }
  @Test
  void testAsync005() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              StepVerifier.create(controller.ctrlAsyncMethod005(input))
                  .expectNextMatches(predicateForInput(input))
                  .expectComplete()
                  .verify();
            });
  }
    
  @Test
  void testSync005() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              final String actual = controller.ctrlSyncMethod005(input);
              assertEquals("OUTPUT: " + input, actual);
            });
  }
  @Test
  void testAsync006() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              StepVerifier.create(controller.ctrlAsyncMethod006(input))
                  .expectNextMatches(predicateForInput(input))
                  .expectComplete()
                  .verify();
            });
  }
    
  @Test
  void testSync006() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              final String actual = controller.ctrlSyncMethod006(input);
              assertEquals("OUTPUT: " + input, actual);
            });
  }
  @Test
  void testAsync007() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              StepVerifier.create(controller.ctrlAsyncMethod007(input))
                  .expectNextMatches(predicateForInput(input))
                  .expectComplete()
                  .verify();
            });
  }
    
  @Test
  void testSync007() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              final String actual = controller.ctrlSyncMethod007(input);
              assertEquals("OUTPUT: " + input, actual);
            });
  }
  @Test
  void testAsync008() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              StepVerifier.create(controller.ctrlAsyncMethod008(input))
                  .expectNextMatches(predicateForInput(input))
                  .expectComplete()
                  .verify();
            });
  }
    
  @Test
  void testSync008() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              final String actual = controller.ctrlSyncMethod008(input);
              assertEquals("OUTPUT: " + input, actual);
            });
  }
  @Test
  void testAsync009() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              StepVerifier.create(controller.ctrlAsyncMethod009(input))
                  .expectNextMatches(predicateForInput(input))
                  .expectComplete()
                  .verify();
            });
  }
    
  @Test
  void testSync009() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              final String actual = controller.ctrlSyncMethod009(input);
              assertEquals("OUTPUT: " + input, actual);
            });
  }
  @Test
  void testAsync010() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              StepVerifier.create(controller.ctrlAsyncMethod010(input))
                  .expectNextMatches(predicateForInput(input))
                  .expectComplete()
                  .verify();
            });
  }
    
  @Test
  void testSync010() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              final String actual = controller.ctrlSyncMethod010(input);
              assertEquals("OUTPUT: " + input, actual);
            });
  }
  @Test
  void testAsync011() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              StepVerifier.create(controller.ctrlAsyncMethod011(input))
                  .expectNextMatches(predicateForInput(input))
                  .expectComplete()
                  .verify();
            });
  }
    
  @Test
  void testSync011() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              final String actual = controller.ctrlSyncMethod011(input);
              assertEquals("OUTPUT: " + input, actual);
            });
  }
  @Test
  void testAsync012() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              StepVerifier.create(controller.ctrlAsyncMethod012(input))
                  .expectNextMatches(predicateForInput(input))
                  .expectComplete()
                  .verify();
            });
  }
    
  @Test
  void testSync012() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              final String actual = controller.ctrlSyncMethod012(input);
              assertEquals("OUTPUT: " + input, actual);
            });
  }
  @Test
  void testAsync013() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              StepVerifier.create(controller.ctrlAsyncMethod013(input))
                  .expectNextMatches(predicateForInput(input))
                  .expectComplete()
                  .verify();
            });
  }
    
  @Test
  void testSync013() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              final String actual = controller.ctrlSyncMethod013(input);
              assertEquals("OUTPUT: " + input, actual);
            });
  }
  @Test
  void testAsync014() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              StepVerifier.create(controller.ctrlAsyncMethod014(input))
                  .expectNextMatches(predicateForInput(input))
                  .expectComplete()
                  .verify();
            });
  }
    
  @Test
  void testSync014() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              final String actual = controller.ctrlSyncMethod014(input);
              assertEquals("OUTPUT: " + input, actual);
            });
  }
  @Test
  void testAsync015() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              StepVerifier.create(controller.ctrlAsyncMethod015(input))
                  .expectNextMatches(predicateForInput(input))
                  .expectComplete()
                  .verify();
            });
  }
    
  @Test
  void testSync015() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              final String actual = controller.ctrlSyncMethod015(input);
              assertEquals("OUTPUT: " + input, actual);
            });
  }
  @Test
  void testAsync016() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              StepVerifier.create(controller.ctrlAsyncMethod016(input))
                  .expectNextMatches(predicateForInput(input))
                  .expectComplete()
                  .verify();
            });
  }
    
  @Test
  void testSync016() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              final String actual = controller.ctrlSyncMethod016(input);
              assertEquals("OUTPUT: " + input, actual);
            });
  }
  @Test
  void testAsync017() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              StepVerifier.create(controller.ctrlAsyncMethod017(input))
                  .expectNextMatches(predicateForInput(input))
                  .expectComplete()
                  .verify();
            });
  }
    
  @Test
  void testSync017() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              final String actual = controller.ctrlSyncMethod017(input);
              assertEquals("OUTPUT: " + input, actual);
            });
  }
  @Test
  void testAsync018() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              StepVerifier.create(controller.ctrlAsyncMethod018(input))
                  .expectNextMatches(predicateForInput(input))
                  .expectComplete()
                  .verify();
            });
  }
    
  @Test
  void testSync018() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              final String actual = controller.ctrlSyncMethod018(input);
              assertEquals("OUTPUT: " + input, actual);
            });
  }
  @Test
  void testAsync019() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              StepVerifier.create(controller.ctrlAsyncMethod019(input))
                  .expectNextMatches(predicateForInput(input))
                  .expectComplete()
                  .verify();
            });
  }
    
  @Test
  void testSync019() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              final String actual = controller.ctrlSyncMethod019(input);
              assertEquals("OUTPUT: " + input, actual);
            });
  }
  @Test
  void testAsync020() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              StepVerifier.create(controller.ctrlAsyncMethod020(input))
                  .expectNextMatches(predicateForInput(input))
                  .expectComplete()
                  .verify();
            });
  }
    
  @Test
  void testSync020() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              final String actual = controller.ctrlSyncMethod020(input);
              assertEquals("OUTPUT: " + input, actual);
            });
  }
  @Test
  void testAsync021() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              StepVerifier.create(controller.ctrlAsyncMethod021(input))
                  .expectNextMatches(predicateForInput(input))
                  .expectComplete()
                  .verify();
            });
  }
    
  @Test
  void testSync021() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              final String actual = controller.ctrlSyncMethod021(input);
              assertEquals("OUTPUT: " + input, actual);
            });
  }
  @Test
  void testAsync022() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              StepVerifier.create(controller.ctrlAsyncMethod022(input))
                  .expectNextMatches(predicateForInput(input))
                  .expectComplete()
                  .verify();
            });
  }
    
  @Test
  void testSync022() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              final String actual = controller.ctrlSyncMethod022(input);
              assertEquals("OUTPUT: " + input, actual);
            });
  }
  @Test
  void testAsync023() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              StepVerifier.create(controller.ctrlAsyncMethod023(input))
                  .expectNextMatches(predicateForInput(input))
                  .expectComplete()
                  .verify();
            });
  }
    
  @Test
  void testSync023() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              final String actual = controller.ctrlSyncMethod023(input);
              assertEquals("OUTPUT: " + input, actual);
            });
  }
  @Test
  void testAsync024() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              StepVerifier.create(controller.ctrlAsyncMethod024(input))
                  .expectNextMatches(predicateForInput(input))
                  .expectComplete()
                  .verify();
            });
  }
    
  @Test
  void testSync024() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              final String actual = controller.ctrlSyncMethod024(input);
              assertEquals("OUTPUT: " + input, actual);
            });
  }
  @Test
  void testAsync025() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              StepVerifier.create(controller.ctrlAsyncMethod025(input))
                  .expectNextMatches(predicateForInput(input))
                  .expectComplete()
                  .verify();
            });
  }
    
  @Test
  void testSync025() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              final String actual = controller.ctrlSyncMethod025(input);
              assertEquals("OUTPUT: " + input, actual);
            });
  }
  @Test
  void testAsync026() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              StepVerifier.create(controller.ctrlAsyncMethod026(input))
                  .expectNextMatches(predicateForInput(input))
                  .expectComplete()
                  .verify();
            });
  }
    
  @Test
  void testSync026() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              final String actual = controller.ctrlSyncMethod026(input);
              assertEquals("OUTPUT: " + input, actual);
            });
  }
  @Test
  void testAsync027() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              StepVerifier.create(controller.ctrlAsyncMethod027(input))
                  .expectNextMatches(predicateForInput(input))
                  .expectComplete()
                  .verify();
            });
  }
    
  @Test
  void testSync027() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              final String actual = controller.ctrlSyncMethod027(input);
              assertEquals("OUTPUT: " + input, actual);
            });
  }
  @Test
  void testAsync028() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              StepVerifier.create(controller.ctrlAsyncMethod028(input))
                  .expectNextMatches(predicateForInput(input))
                  .expectComplete()
                  .verify();
            });
  }
    
  @Test
  void testSync028() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              final String actual = controller.ctrlSyncMethod028(input);
              assertEquals("OUTPUT: " + input, actual);
            });
  }
  @Test
  void testAsync029() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              StepVerifier.create(controller.ctrlAsyncMethod029(input))
                  .expectNextMatches(predicateForInput(input))
                  .expectComplete()
                  .verify();
            });
  }
    
  @Test
  void testSync029() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              final String actual = controller.ctrlSyncMethod029(input);
              assertEquals("OUTPUT: " + input, actual);
            });
  }
  @Test
  void testAsync030() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              StepVerifier.create(controller.ctrlAsyncMethod030(input))
                  .expectNextMatches(predicateForInput(input))
                  .expectComplete()
                  .verify();
            });
  }
    
  @Test
  void testSync030() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              final String actual = controller.ctrlSyncMethod030(input);
              assertEquals("OUTPUT: " + input, actual);
            });
  }
  @Test
  void testAsync031() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              StepVerifier.create(controller.ctrlAsyncMethod031(input))
                  .expectNextMatches(predicateForInput(input))
                  .expectComplete()
                  .verify();
            });
  }
    
  @Test
  void testSync031() {
    Service012 service = new Service012();
    Controller012 controller = new Controller012(service);

    IntStream.range(1, 5)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              final String actual = controller.ctrlSyncMethod031(input);
              assertEquals("OUTPUT: " + input, actual);
            });
  }

}
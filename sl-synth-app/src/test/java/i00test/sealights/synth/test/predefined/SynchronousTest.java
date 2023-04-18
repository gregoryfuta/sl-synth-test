package i00test.sealights.synth.test.predefined;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import gen.i0.sealights.synth.app.module000.api.Controller000;
import gen.i0.sealights.synth.app.module000.api.Controller001;
import gen.i0.sealights.synth.app.module000.service.Service000;
import gen.i0.sealights.synth.app.module000.service.Service001;
import i00test.sealights.synth.test.common.FootprintsResultClient;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@DisplayName("SynchronousTest")
@TestMethodOrder(MethodOrderer.MethodName.class)
public class SynchronousTest {

  final FootprintsResultClient footprintsResultClient =
      new FootprintsResultClient("http://localhost:9900");

  @Test
  void testSync000() {
    Service000 service = new Service000();
    Controller000 controller = new Controller000(service);

    IntStream.range(1, 50)
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              final String actual = controller.ctrlSyncMethod000(input);
              assertEquals("OUTPUT: " + input, actual);
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
              final String actual = controller.ctrlSyncMethod000(input);
              assertEquals("OUTPUT: " + input, actual);
            });
  }

  @Test
  void zzzFootprintsVerificationTest() throws InterruptedException {
    HashMap<String, List<String>> expectedHits =
        new HashMap<String, List<String>>() {
          {
            put(
                "i00test.sealights.synth.test.predefined.SynchronousTest.testSync000",
                asList(
                    "gen.i0.sealights.synth.app.module000.service.Service000.method000",
                    "gen.i0.sealights.synth.app.module000.api.Controller000.ctrlSyncMethod000",
                    "gen.i0.sealights.synth.app.module000.service.Service000.sleep"));
            put(
                "i00test.sealights.synth.test.predefined.SynchronousTest.testSync001",
                asList(
                    "gen.i0.sealights.synth.app.module000.service.Service001.method000",
                    "gen.i0.sealights.synth.app.module000.api.Controller001.ctrlSyncMethod000",
                    "gen.i0.sealights.synth.app.module000.service.Service001.sleep"));
          }
        };

    //    Thread.sleep(5000);
    final Map<String, List<String>> testToHitsMapping = footprintsResultClient.fetchFootprints();

    // then
    assertEquals(2, testToHitsMapping.size());
    assertHitsForTest(expectedHits, testToHitsMapping);
  }

  private void assertHitsForTest(
      HashMap<String, List<String>> expectedHits, Map<String, List<String>> testToHitsMapping) {
    expectedHits.forEach(
        (key, value) -> {
          assertTrue(testToHitsMapping.containsKey(key));
          assertExpectedMethodsWereExecuted(value, testToHitsMapping.get(key));
        });
  }

  private void assertExpectedMethodsWereExecuted(
      List<String> expectedMethods, List<String> actualHits) {
    expectedMethods.forEach(
        expectedMethod -> assertTrue(arrayContainsSubstring(expectedMethod, actualHits)));
  }

  private boolean arrayContainsSubstring(String expectedMethod, List<String> actualHits) {
    for (String actualHit : actualHits) {
      if (actualHit.contains(expectedMethod)) {
        return true;
      }
    }
    return false;
  }
}

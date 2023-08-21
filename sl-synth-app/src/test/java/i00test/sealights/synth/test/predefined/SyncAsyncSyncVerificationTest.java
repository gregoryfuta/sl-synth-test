package i00test.sealights.synth.test.predefined;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

import i00test.sealights.synth.test.common.FootprintsResultClient;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;

@DisplayName("ZZZ SyncAsyncSyncVerificationTest")
@TestClassOrder(ClassOrderer.DisplayName.class)
public class SyncAsyncSyncVerificationTest {

  final FootprintsResultClient footprintsResultClient =
      FootprintsResultClient.createFootprintsResultClient();

  @Test
  void zzzFootprintsVerificationTest() throws InterruptedException {
    System.out.println("XXXXXXXXXXXXXX: HIT SIZES 222: ");
    HashMap<String, List<String>> expectedHits =
        new HashMap<String, List<String>>() {
          {
            put(
                "i00test.sealights.synth.test.predefined.SyncAsyncSyncTest.testStep000_syncAsyncSyncCall",
                asList(
                    "gen.i0.sealights.synth.app.module000.service.Service000.method000",
                    "gen.i0.sealights.synth.app.module000.api.Controller000.ctrlSyncMethod000",
                    "gen.i0.sealights.synth.app.module000.service.Service000.sleep"));
            put(
                "i00test.sealights.synth.test.predefined.SyncAsyncSyncTest.testStep001_syncAsyncSyncCall",
                asList(
                    "gen.i0.sealights.synth.app.module000.service.Service001.method001",
                    "gen.i0.sealights.synth.app.module000.service.Service001.method000",
                    "gen.i0.sealights.synth.app.module000.api.Controller001.ctrlSyncMethod001",
                    "gen.i0.sealights.synth.app.module000.api.Controller001.ctrlSyncMethod000",
                    "gen.i0.sealights.synth.app.module000.service.Service001.sleep"));
          }
        };

    //    Thread.sleep(12000);
    final Map<String, List<String>> testToHitsMapping = footprintsResultClient.fetchFootprints();

    // then

    try (PrintWriter out = new PrintWriter(".\\async-v3.txt." + System.currentTimeMillis())) {
      System.out.println("########################### START");
      testToHitsMapping.forEach(
          (k, v) -> {
            System.out.println(" ###########################");
            System.out.println(" # K: " + k);
            out.println("K: " + k);
            System.out.println(" # V: " + v.size());
            v.sort(Comparator.naturalOrder());
            v.forEach(out::println);
            System.out.println(" ###########################");
          });
      System.out.println("###########################  end");
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
    assertEquals(2, testToHitsMapping.size());
    //    assertHitsForTest(expectedHits, testToHitsMapping);
  }
}

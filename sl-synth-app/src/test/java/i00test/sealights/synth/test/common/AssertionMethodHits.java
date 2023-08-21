package i00test.sealights.synth.test.common;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AssertionMethodHits {
  public static void assertHitsForTest(
      HashMap<String, List<String>> expectedHits, Map<String, List<String>> testToHitsMapping) {
    expectedHits.forEach(
        (key, value) -> {
          assertTrue(testToHitsMapping.containsKey(key));
          assertExpectedMethodsWereExecuted(value, testToHitsMapping.get(key));
        });
  }

  private static void assertExpectedMethodsWereExecuted(
      List<String> expectedMethods, List<String> actualHits) {
    expectedMethods.forEach(
        expectedMethod -> assertTrue(arrayContainsSubstring(expectedMethod, actualHits)));
  }

  private static boolean arrayContainsSubstring(String expectedMethod, List<String> actualHits) {
    for (String actualHit : actualHits) {
      if (actualHit.contains(expectedMethod)) {
        return true;
      }
    }
    return false;
  }
}

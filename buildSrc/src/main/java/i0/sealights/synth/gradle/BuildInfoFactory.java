package i0.sealights.synth.gradle;

import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import org.gradle.api.Project;

import java.time.LocalDateTime;
import java.util.Map;

public class BuildInfoFactory {

  private static final List<String> PROJECT_PROPERTIES_TO_EXCLUDE = Arrays.asList("");
  private static final List<String> SYSTEM_PROPERTIES_TO_EXCLUDE = Arrays.asList("");

  public static BuildInfo createBuildInfo(Project project) {
    LocalDateTime creationDate = LocalDateTime.now();
    String osInformation = System.getProperty("os.name") + " " + System.getProperty("os.version");
    String javaVersion = System.getProperty("java.version");
    String javaVendor = System.getProperty("java.vendor");

    Map<String, String> systemProperties =
        System.getProperties().entrySet().stream()
            .filter(entry -> entry != null && entry.getKey() != null && entry.getValue() != null)
            .filter(BuildInfoFactory::systemPropertyToSave)
            .collect(Collectors.toMap(e -> e.getKey().toString(), e -> e.getValue().toString()));

    Map<String, String> projectProperties =
        project.getProperties().entrySet().stream()
            .filter(entry -> entry != null && entry.getKey() != null && entry.getValue() != null)
            .filter(BuildInfoFactory::projectPropertyToSave)
            .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue().toString()));
    String gradleVersion = project.getGradle().getGradleVersion();

    final String testRunId = System.getProperty("testRunId");

    return new BuildInfo.Builder()
        .creationDate(creationDate)
        .testRunId(testRunId != null && !testRunId.isEmpty() ? testRunId : "RUN_AT_" + creationDate)
        .osInformation(osInformation)
        .javaVersion(javaVersion)
        .javaVendor(javaVendor)
        .systemProperties(systemProperties)
        .projectProperties(projectProperties)
        .gradleVersion(gradleVersion)
        .build();
  }

  private static boolean systemPropertyToSave(Entry<Object, Object> entry) {
    return !SYSTEM_PROPERTIES_TO_EXCLUDE.contains(entry.getKey().toString());
  }

  private static boolean projectPropertyToSave(Entry<String, ?> entry) {
    return !PROJECT_PROPERTIES_TO_EXCLUDE.contains(entry.getKey());
  }
}

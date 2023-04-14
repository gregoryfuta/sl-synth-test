package i0.sealights.synth.gradle;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BuildInfoCsvWriter {
  private final File file;
  private static final List<String> PROJECT_KEYS =
      Arrays.asList("path", "targetCompatibility", "version", "sourceCompatibility", "buildFile");
  private static final List<String> SYSTEM_KEYS =
      Arrays.asList(
          "java.class.path",
          "sun.arch.data.model",
          "sun.management.compiler",
          "java.runtime.version",
          "os.version",
          "user.dir",
          "os.arch=amd64");

  public BuildInfoCsvWriter(Path filePath) {
    this.file = new File(filePath.toString());
    if (!file.exists()) {
      createNewFile();
    }
  }

  private void createNewFile() {
    try {
      boolean created = file.createNewFile();
      System.out.println("new file created: " + created);
      writeCsvRow(
          "phase,creationDate,testRunId,osInformation,javaVersion,javaVendor,systemProperties,projectProperties,gradleVersion,executionTime");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public void writeCsvRow(String phase, BuildInfo buildInfo) {
    StringBuilder sb =
        new StringBuilder()
            .append(phase)
            .append(",")
            .append(buildInfo.getCreationDate())
            .append(",")
            .append(buildInfo.getTestRunId())
            .append(",")
            .append(buildInfo.getOsInformation())
            .append(",")
            .append(buildInfo.getJavaVersion())
            .append(",")
            .append(buildInfo.getJavaVendor())
            .append(",")
            .append(serializeProperties(buildInfo.getSystemProperties(), SYSTEM_KEYS))
            .append(",")
            .append(serializeProperties(buildInfo.getProjectProperties(), PROJECT_KEYS))
            .append(",")
            .append(buildInfo.getGradleVersion())
            .append(",")
            .append(buildInfo.getExecutionTime() != null ? buildInfo.getExecutionTime() : "");

    writeCsvRow(sb.toString());
  }

  private static String serializeProperties(
      Map<String, String> properties, Collection<String> keysToBeSaved) {
    return properties.entrySet().stream()
        .filter(entry -> keysToBeSaved.contains(entry.getKey()))
        .map(entry -> entry.getKey() + "=" + entry.getValue())
        .collect(Collectors.joining(";"));
  }

  private synchronized void writeCsvRow(String row) {
    try (FileWriter fw = new FileWriter(file, true)) {
      fw.append(row).append("\n");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}

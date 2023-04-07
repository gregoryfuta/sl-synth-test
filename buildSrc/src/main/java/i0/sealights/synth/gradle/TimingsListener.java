package i0.sealights.synth.gradle;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.gradle.api.Task;
import org.gradle.api.execution.TaskExecutionListener;
import org.gradle.api.tasks.TaskState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimingsListener implements TaskExecutionListener {

  private static final Logger LOG = LoggerFactory.getLogger(TimingsListener.class);

  private static final String REPORT_FOLDER = "synth-results";

  private static final List<String> VALID_TASK_TYPES = Arrays.asList("test", "compile");

  private Map<String, BuildInfo> invocationData = new HashMap<>();
  private Map<String, Long> startTimeForTask = new HashMap<>();

  @Override
  public void beforeExecute(Task task) {
    final String taskName = task.getName();
    if (!VALID_TASK_TYPES.contains(taskName)) {
      return;
    }

    final BuildInfo buildInfo = BuildInfoFactory.createBuildInfo(task.getProject());
    invocationData.put(taskName, buildInfo);
    startTimeForTask.put(taskName, System.currentTimeMillis());
  }

  @Override
  public void afterExecute(Task task, TaskState taskState) {
    String taskName = task.getName();
    if (!VALID_TASK_TYPES.contains(taskName)) {
      return;
    }
    storeExecutionTime(taskName);
    appendCsvResultFile(task, taskName);
  }

  private void appendCsvResultFile(Task task, String taskName) {
    final File rootDir = task.getProject().getRootDir();
    final String projectName = task.getProject().getName();
    final Path reportResultPath = Paths.get(rootDir.getPath(), REPORT_FOLDER);
    
    try {
      Files.createDirectory(reportResultPath);
    } catch (IOException e) {
      LOG.info("Folder: '" + REPORT_FOLDER + "' already exists");
    }
    final BuildInfoCsvWriter buildInfoCsvWriter =
        new BuildInfoCsvWriter(Paths.get(reportResultPath.toString(), projectName + "-results.csv"));

    buildInfoCsvWriter.writeCsvRow(taskName, invocationData.get(taskName));
  }

  private void storeExecutionTime(String taskName) {
    long endTime = System.currentTimeMillis();
    long startTime = startTimeForTask.get(taskName);
    invocationData.get(taskName).setExecutionTime(endTime - startTime);
  }

  public String doSmth() {
    return "doing something";
  }
}

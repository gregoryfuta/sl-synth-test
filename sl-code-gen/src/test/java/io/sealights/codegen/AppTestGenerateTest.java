package io.sealights.codegen;

import static java.util.Objects.isNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class AppTestGenerateTest {

  private String generatorSourcePath;
  private String generatorTestPackageName;
  private String generatorModuleCount;
  private String generatorClassCount;
  private String generatorMethodCount;

  @BeforeAll
  void setupProperties() {
    generatorSourcePath = System.getProperty("generatorSourcePath");
    generatorTestPackageName = System.getProperty("generatorTestPackageName");
    generatorModuleCount = System.getProperty("generatorModuleCount");
    generatorClassCount = System.getProperty("generatorClassCount");
    generatorMethodCount = System.getProperty("generatorMethodCount");
  }

  @Test
  void generateApplicationTestTask() {

    if (isNull(generatorTestPackageName) || generatorTestPackageName.isEmpty()) {
      return;
    }

    final BuildParameters buildParameters =
        BuildParameters.builder()
            .sourceDir(generatorSourcePath)
            .basePackage(generatorTestPackageName)
            .modulesCount(Integer.parseInt(generatorModuleCount))
            .classCount(Integer.parseInt(generatorClassCount))
            .methodCount(Integer.parseInt(generatorMethodCount))
            .build();

    JavaFilesGenerator javaFilesGenerator = new JavaFilesGenerator();
    TestCodeGenerator codeGenerator = new TestCodeGenerator(javaFilesGenerator);
    codeGenerator.generate(buildParameters);
  }
}

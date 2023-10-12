package io.sealights.codegen;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestCodeGenerator {

  private static final Logger log = LoggerFactory.getLogger(TestCodeGenerator.class);

  private static final String MODULE_PACKAGE_NAME = "module";
  private static final String SERVICE_FILENAME_PATTERN = "Service%03dTest.java";

  private static final Pattern FIND_DOTS_PATTERN = Pattern.compile("\\.");

  private final JavaFilesGenerator javaFilesGenerator;

  public TestCodeGenerator(JavaFilesGenerator javaFilesGenerator) {
    this.javaFilesGenerator = javaFilesGenerator;
  }

  void generate(final BuildParameters genParameters) {
    final String javaSourceDir = genParameters.getSourceDir() + "/test/java";

    removeExistingPackages(javaSourceDir, genParameters.getBasePackage());
    createBasePackage(javaSourceDir, genParameters.getBasePackage());
    createModules(javaSourceDir, genParameters.getBasePackage(), genParameters.getModulesCount());

    createSourceFiles(javaSourceDir, genParameters);
  }

  private void createSourceFiles(String javaSourceDir, BuildParameters genParameters) {
    final String path = packageToDirectories(genParameters.getBasePackage());
    final Pattern findModuleNumberPattern = createModuleFindPattern(genParameters.getBasePackage());
    final String separatorWithModule = File.separator + MODULE_PACKAGE_NAME + File.separator;
    try {
      Path start = Paths.get(javaSourceDir, path);
      Files.walk(start)
          .filter(path2 -> path2.toString().contains(separatorWithModule))
          .forEach(it -> createTestClasses(it, genParameters, findModuleNumberPattern));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private void createTestClasses(
      Path packagePath, BuildParameters genParameters, Pattern moduleNumberFindPattern) {
    final String currentPackage = packagePath.toString().replaceAll("\\\\", ".");
    final String currentModule = extractCurrentModule(moduleNumberFindPattern, currentPackage);
    IntStream.range(0, genParameters.getClassCount())
        .forEach(
            classNo -> {
              try (FileWriter fileWriter =
                  new FileWriter(
                      packagePath
                          + File.separator
                          + String.format(SERVICE_FILENAME_PATTERN, classNo))) {

                javaFilesGenerator.generateTest(
                    genParameters.getBasePackage() + "." + MODULE_PACKAGE_NAME + currentModule,
                    currentModule,
                    classNo,
                    genParameters.getMethodCount(),
                    fileWriter);
              } catch (IOException e) {
                throw new RuntimeException(e);
              }
            });
  }

  private static String extractCurrentModule(
      Pattern moduleNumberFindPattern, String currentPackage) {
    Matcher matcher = moduleNumberFindPattern.matcher(currentPackage);
    if (!matcher.matches()) {
      throw new RuntimeException(
          "Can not extract current module name for package '"
              + currentPackage
              + "' and using pattern'"
              + moduleNumberFindPattern
              + "'");
    }
    return matcher.group(1);
  }

  private void createModules(String javaSourceDir, String basePackage, int modulesCount) {
    final String path = packageToDirectories(basePackage) + "/" + MODULE_PACKAGE_NAME;
    for (int i = 0; i < modulesCount; i++) {
      final String moduleName = String.format(path + "%03d", i);
      try {
        Files.createDirectories(Paths.get(javaSourceDir, moduleName));
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
  }

  private Path createBasePackage(String javaSourceDir, String basePackage) {
    try {
      String path = packageToDirectories(basePackage);
      Path createdPath = Paths.get(javaSourceDir, path);
      Files.createDirectories(createdPath);
      return createdPath;
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private static String packageToDirectories(String basePackage) {
    return FIND_DOTS_PATTERN.matcher(basePackage).replaceAll("/");
  }

  private String packageToPattern(String basePackage) {
    return FIND_DOTS_PATTERN.matcher(basePackage).replaceAll("\\\\.");
  }

  private void removeExistingPackages(String sourceDir, String basePackage) {
    if (basePackage.isEmpty()) {
      return;
    }
    final String[] split = basePackage.split("\\.");

    try (Stream<Path> filePathsStream = Files.walk(Paths.get(sourceDir, split[0]))) {
      filePathsStream
          .sorted(Comparator.reverseOrder())
          .map(Path::toFile)
          .filter(File::exists)
          .forEach(File::delete);
    } catch (NoSuchFileException noSuchFileException) {
      log.info("File '{}' does not exists", noSuchFileException.getFile());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private Pattern createModuleFindPattern(String basePackageName) {
    return Pattern.compile(
        ".+" + packageToPattern(basePackageName) + "\\." + MODULE_PACKAGE_NAME + "(\\d+)");
  }
}

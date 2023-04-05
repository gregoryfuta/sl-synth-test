package io.sealights.codegen;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CodeGenerator {

    private static final Logger log = LoggerFactory.getLogger(CodeGenerator.class);

    private static final String API_PACKAGE = "api";
    private static final String SERVICE_PACKAGE = "service";
    private final List<String> moduleSubpackages = Arrays.asList(API_PACKAGE, SERVICE_PACKAGE);
    private final String modulePackageName = "module";
    private static final String SERVICE_FILENAME_PATTERN = "Service%03d.java";
    private static final String CONTROLLER_FILENAME_PATTERN = "Controller%03d.java";

    private JavaFilesGenerator javaFilesGenerator;

    public CodeGenerator(JavaFilesGenerator javaFilesGenerator) {
        this.javaFilesGenerator = javaFilesGenerator;
    }

    void generate(final BuildParameters genParameters) {
        removeExistingPackages(genParameters.getBasePackage());
        createBasePackage(genParameters.getBasePackage());
        createModules(genParameters.getBasePackage(), genParameters.getModulesCount());

        createSourceFiles(genParameters);
    }

    private void createSourceFiles(BuildParameters genParameters) {
        final String path = packageToDirectories(genParameters.getBasePackage());
        try {
            Path start = Paths.get(path);
            Files.walk(start)
                .filter(it -> it.endsWith(API_PACKAGE))
                .forEach(it -> createControllers(it, genParameters));

            Files.walk(start)
                .filter(it -> it.endsWith(SERVICE_PACKAGE))
                .forEach(it -> createServices(it, genParameters));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createServices(Path packagePath, BuildParameters genParameters) {
        final String currentPackage = packagePath.toString().replaceAll("\\\\", ".");
        IntStream.range(0, genParameters.getClassCount()).forEach(classNo -> {
            try {
                FileWriter fileWriter = new FileWriter(packagePath
                    + File.separator
                    + String.format(SERVICE_FILENAME_PATTERN, classNo));

                javaFilesGenerator.generateService(currentPackage, classNo, genParameters.getMethodCount(), fileWriter);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void createControllers(Path packagePath, BuildParameters genParameters) {
        final String currentPackage = packagePath.toString().replaceAll("\\\\", ".");
        IntStream.range(0, genParameters.getClassCount()).forEach(classNo -> {
            try {
                FileWriter fileWriter = new FileWriter(packagePath
                    + File.separator
                    + String.format(CONTROLLER_FILENAME_PATTERN, classNo));

                javaFilesGenerator.generateController(currentPackage,
                    classNo,
                    genParameters.getMethodCount(),
                    fileWriter);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void createModules(String basePackage, int modulesCount) {
        final String path = packageToDirectories(basePackage) + "/" + modulePackageName;
        for (int i = 0; i < modulesCount; i++) {
            final String moduleName = String.format(path + "%03d", i);
            moduleSubpackages.forEach(subpacakge -> {
                try {
                    Files.createDirectories(Paths.get(moduleName, subpacakge));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    private Path createBasePackage(String basePackage) {
        try {
            String path = packageToDirectories(basePackage);
            Path createdPath = Paths.get(path);
            Files.createDirectories(createdPath);
            return createdPath;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String packageToDirectories(String basePackage) {
        return basePackage.replaceAll("\\.", "/");
    }

    private void removeExistingPackages(String basePackage) {
        if (basePackage.isEmpty()) {
            return;
        }
        final String[] split = basePackage.split("\\.");

        try (Stream<Path> filePathsStream = Files.walk(Paths.get(split[0]))) {
            filePathsStream
                .map(Path::toFile)
                .filter(File::exists)
                .forEach(File::delete);
        } catch (NoSuchFileException noSuchFileException) {
            log.info("File '{}' does not exists", noSuchFileException.getFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

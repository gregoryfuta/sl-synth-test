package io.sealights.codegen;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class AppSourcesGenerateTest {

    private String generatorSourcePath;
    private String generatorPackageName;
    private String generatorModuleCount;
    private String generatorClassCount;
    private String generatorMethodCount;

    @BeforeAll
    void setupProperties() {
        generatorSourcePath = System.getProperty("generatorSourcePath");
        generatorPackageName = System.getProperty("generatorPackageName");
        generatorModuleCount = System.getProperty("generatorModuleCount");
        generatorClassCount = System.getProperty("generatorClassCount");
        generatorMethodCount = System.getProperty("generatorMethodCount");
    }

    @Test
    void generateApplicationSourcesTask() {

        final BuildParameters buildParameters = BuildParameters.builder()
            .sourceDir(generatorSourcePath)
            .basePackage(generatorPackageName)
            .modulesCount(Integer.parseInt(generatorModuleCount))
            .classCount(Integer.parseInt(generatorClassCount))
            .methodCount(Integer.parseInt(generatorMethodCount))
            .build();

        JavaFilesGenerator javaFilesGenerator = new JavaFilesGenerator();
        CodeGenerator codeGenerator = new CodeGenerator(javaFilesGenerator);
        codeGenerator.generate(buildParameters);
    }
}

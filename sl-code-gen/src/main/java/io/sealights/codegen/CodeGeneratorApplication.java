package io.sealights.codegen;

public class CodeGeneratorApplication {

    public static void main(String[] args) {
        System.out.println("Code generation application");

        final BuildParameters buildParameters = BuildParameters.builder()
            .methodCount(2)
            .classCount(1)
            .build();

        JavaFilesGenerator javaFilesGenerator = new JavaFilesGenerator();
        SourceCodeGenerator sourceCodeGenerator = new SourceCodeGenerator(javaFilesGenerator);
        sourceCodeGenerator.generate(buildParameters);
        
    }
}
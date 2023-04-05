package io.sealights.codegen;

import static freemarker.template.Configuration.VERSION_2_3_23;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.Writer;

public class JavaFilesGenerator {

    private Configuration configuration;

    public JavaFilesGenerator() {
        initializeTemplateEngine();
    }

    void generateController(String packageName, int classNo, int methodCunt, Writer writer) {
        generateFileWIthTemplate("template/ControllerTemplate.ftl", packageName, classNo, methodCunt, writer);
    }

    void generateService(String packageName, int classNo, int methodCunt, Writer writer) {
        generateFileWIthTemplate("template/ServiceTemplate.ftl", packageName, classNo, methodCunt, writer);
    }

    void generateFileWIthTemplate(String templateFilename, String packageName, int classNo, int methodCunt, Writer writer) {
        Template template;
        try {
            template = configuration.getTemplate(templateFilename);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        DataModel dataModel = DataModel.builder()
            .classNo(String.format("%03d", classNo))
            .methodCount(methodCunt)
            .packageName(packageName)
            .build();

        try {
            template.process(dataModel, writer);
        } catch (TemplateException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void initializeTemplateEngine() {
        configuration = new Configuration(VERSION_2_3_23);
        configuration.setClassForTemplateLoading(CodeGenerator.class, "/");
        configuration.setDefaultEncoding("UTF-8");
    }
}

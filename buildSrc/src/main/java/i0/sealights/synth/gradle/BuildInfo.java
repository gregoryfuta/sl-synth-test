package i0.sealights.synth.gradle;

import java.time.LocalDateTime;
import java.util.Map;

public class BuildInfo {
    private final LocalDateTime creationDate;
    private final String osInformation;
    private final String javaVersion;
    private final String javaVendor;
    private Long executionTime;
    private final Map<String, String> systemProperties;
    private final Map<String, String> projectProperties;
    private final String gradleVersion;

    private BuildInfo(LocalDateTime creationDate, String osInformation, String javaVersion, String javaVendor,
        Long executionTime, Map<String, String> systemProperties, Map<String, String> projectProperties,
        String gradleVersion) {
        this.creationDate = creationDate;
        this.osInformation = osInformation;
        this.javaVersion = javaVersion;
        this.javaVendor = javaVendor;
        this.executionTime = executionTime;
        this.systemProperties = systemProperties;
        this.projectProperties = projectProperties;
        this.gradleVersion = gradleVersion;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public String getOsInformation() {
        return osInformation;
    }

    public String getJavaVersion() {
        return javaVersion;
    }

    public String getJavaVendor() {
        return javaVendor;
    }

    public Long getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Long executionTime) {
        this.executionTime = executionTime;
    }

    public Map<String, String> getSystemProperties() {
        return systemProperties;
    }

    public Map<String, String> getProjectProperties() {
        return projectProperties;
    }

    public String getGradleVersion() {
        return gradleVersion;
    }

    public static class Builder {
        private LocalDateTime creationDate;
        private String osInformation;
        private String javaVersion;
        private String javaVendor;
        private Long executionTime;
        private Map<String, String> systemProperties;
        private Map<String, String> projectProperties;
        private String gradleVersion;

        public Builder creationDate(LocalDateTime creationDate) {
            this.creationDate = creationDate;
            return this;
        }

        public Builder osInformation(String osInformation) {
            this.osInformation = osInformation;
            return this;
        }

        public Builder javaVersion(String javaVersion) {
            this.javaVersion = javaVersion;
            return this;
        }

        public Builder javaVendor(String javaVendor) {
            this.javaVendor = javaVendor;
            return this;
        }

        public Builder executionTime(Long executionTime) {
            this.executionTime = executionTime;
            return this;
        }

        public Builder systemProperties(Map<String, String> systemProperties) {
            this.systemProperties = systemProperties;
            return this;
        }

        public Builder projectProperties(Map<String, String> projectProperties) {
            this.projectProperties = projectProperties;
            return this;
        }

        public Builder gradleVersion(String gradleVersion) {
            this.gradleVersion = gradleVersion;
            return this;
        }

        public BuildInfo build() {
            return new BuildInfo(creationDate, osInformation, javaVersion, javaVendor, executionTime, systemProperties,
                projectProperties, gradleVersion);
        }
    }
}


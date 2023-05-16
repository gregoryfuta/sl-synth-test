buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        "classpath"(
            group = "io.sealights.on-premise.agents.plugin",
            name = "sealights-gradle-plugin",
            version = "4.0.819"
        )
    }
}

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.11"
	id("io.spring.dependency-management") version "1.0.15.RELEASE"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
	id("jacoco")
}

group = "i0.sealights.koltin"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
	gradlePluginPortal()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

allprojects {
    val included: List<String> = listOf()
    val excluded: List<String> = listOf()

    if (!included.isEmpty()) {
        println("[SeaLights Integration] Including only projects: ${included}")
    }

    if (!excluded.isEmpty()) {
        println("[SeaLights Integration] Excluding projects: ${excluded}")
    }

    if (!excluded.contains(name) &&
        (included.isEmpty() || included.contains(name))
    ) {
        println("[SeaLights Integration] SeaLights applied to project: '${name}'")

        afterEvaluate {
            apply {
                plugin(io.sealights.onpremise.agents.plugin.SealightsPlugin::class.java)
            }
            configure<io.sealights.onpremise.agents.plugin.SealightsPluginExtension> {
                tokenFile = "./sltoken.txt"
                appName = "testGroupId"
                packagesIncluded = "*sealights.kotlin.*"
                packagesExcluded = "*model*"
                isRecursive = true
                isIncludeResources = true
                filesStorage = "/tmp"
                isLogEnabled = true
                isLogPluginMinimal = false
                logLevel = "debug"
                isCreateBuildSessionId = true
                isCreatePRBuildSessionId = false
                testTasksAndStages = mapOf("test" to "Test Tests")
                isLogToFile = false
                isLogToConsole = true
                build = "redlock-kotlin-002"
                branch = "develop"

            }
        }
    }
}

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

//configure<SealightsPluginExtension> {
//	token = "eyJhbGciOiJSUzUxMiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJodHRwczovL0RFVi1ncmVnLmF1dGguc2VhbGlnaHRzLmlvLyIsImp3dGlkIjoiREVWLWdyZWcsaS0wOGFjODQxODlhYWFhZWFkMyxBUElHVy0zM2M0MTY5MS02MTU1LTRhMzktYTU5OC0yZjVkMGE0YTE4NGQsMTY4MjU3NzEwODA1NSIsInN1YmplY3QiOiJTZWFMaWdodHNAYWdlbnQiLCJhdWRpZW5jZSI6WyJhZ2VudHMiXSwieC1zbC1yb2xlIjoiYWdlbnQiLCJ4LXNsLXNlcnZlciI6Imh0dHBzOi8vZGV2LWdyZWctZ3cuZGV2LnNlYWxpZ2h0cy5jby9hcGkiLCJzbF9pbXBlcl9zdWJqZWN0IjoiIiwiaWF0IjoxNjgyNTc3MTA4fQ.ZqDvrmq1mrCPqWNE7p900fImKTnYZmV0ZBkte0aEF0BTDXn7b4wjsBpgvkmeCfZxgd8fSqxmFniqEsLaWNOJ_mQKLpfQP7rKUEJyy629r5Ni-eouh8wxLlCuWPLnkSBLG4gSEy7NUjfPCQT0hzOjSVQ61GJNEaqJ2QxpGihf85RiFwArxA-mIHa8QB1vSgAJfRePlX8foPF2exce43JdJobLYSCsqDv0cmxHHV813TPgxclMVX1R7a20nOJ0GkaMEel3GSXCVhhxbSW2tOK-WgCoOJIypP7RNBUnUU2t2zHh8_FrfpHweIKWOQK22mpKqpGTqc7y7Df0pX7rXXDWs3Fx_ayTBP-PmU2LMlv4tptKwKTtbz9uFkUasWmH27tnMEw06M9mJGecKYPzaGdMDNn2a814XnMKRlbnv2O_Ux8cvHhb2aUX4zqmU_cDCPw4dJY46wFjATkzDN8hwak0R8XXUK1STNW9ksc4gbbXkiuHybs7c7gdo0QiHnClu3KU3Rh_Ml0RScXCVBlXHJF9DXc7UueLI5mGBFfEUxas6zYQvft4QElj4caPIOYOI7Ss-vgjAJ1lQHqKcWZPBf_5hRK16woiAdix6oag1aR5EYeUZ4IQV5pshyxIhg3I4bJr3oZok_JBWa4LuRoa1Q7_f_09aR6-LQ8nlGxLbd5nCdQ"
//	isCreateBuildSessionId = true
//	logLevel = "DEUG"
//	isLogEnabled = true
//	appName = "testGroupId"
//	branch = "develop"
//	build = "redlock_001"
//	packagesIncluded = "*sealights.kotlin.*"
//	packagesExcluded = "*model*"
//	isIncludeResources = true
//	filesStorage = "/tmp"
//	testTasksAndStages = mapOf(Pair("test","Unit Tests"))
//}
//
//allprojects {
//	apply<SealightsPlugin>()
//}


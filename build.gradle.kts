import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.5.4" apply false
	id("io.spring.dependency-management") version "1.0.11.RELEASE" apply false
	kotlin("jvm") version "1.5.21" apply false
	kotlin("plugin.spring") version "1.5.21" apply false
    kotlin("plugin.jpa") version "1.5.21" apply false
	id("org.jlleitschuh.gradle.ktlint") version "10.1.0" apply false
}

allprojects {
	group = "com.helloworld"
	version = "0.0.1-SNAPSHOT"

	tasks.withType<KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs = listOf("-Xjsr305=strict")
			jvmTarget = "11"
		}
	}

	tasks.withType<Test> {
		useJUnitPlatform()
	}
}

subprojects {
	repositories {
		mavenCentral()
	}

	apply {
		plugin("io.spring.dependency-management")
		plugin("org.springframework.boot")
		plugin("kotlin")
		plugin("kotlin-kapt")
		plugin("java")
		plugin("org.jlleitschuh.gradle.ktlint")
	}

	dependencies {
		"implementation"("org.springframework.boot:spring-boot-starter")
		"implementation"("org.jetbrains.kotlin:kotlin-reflect")
		"implementation"("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
		"testImplementation"("org.springframework.boot:spring-boot-starter-test")
	}

    configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
        debug.set(true)
        disabledRules.add("no-wildcard-imports")
    }
}





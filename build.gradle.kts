import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    kotlin("jvm") version "1.3.50"
}

group = "io.github.abelhegedus"
version = "0.1-SNAPSHOT"

repositories {
    jcenter()
}

dependencies {
    compile(kotlin("stdlib-jdk8"))

    implementation("io.vertx", "vertx-lang-kotlin", "3.8.3") {
        exclude("org.jetbrains.kotlin","kotlin-stdlib-jre8")
        exclude("org.jetbrains.kotlin","kotlin-stdlib-jre7")
    }
    implementation("io.vertx", "vertx-web", "3.8.3")
    implementation("io.vertx", "vertx-web-api-contract", "3.8.3")

    testCompile("junit", "junit", "4.12")
    testCompile("org.jetbrains.kotlin", "kotlin-test-junit")
    testCompile("io.vertx", "vertx-unit", "3.8.3")
    testCompile("io.vertx", "vertx-web-client", "3.8.3")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.withType<Wrapper> {
    gradleVersion = "5.6.1"
    distributionType = Wrapper.DistributionType.ALL
}
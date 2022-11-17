import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.21"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
    //maven(url = "https://s01.oss.sonatype.org/content/repositories/snapshots/")
    //maven(url = "https://oss.sonatype.org/content/repositories/snapshots/")
}

dependencies {
    // a random potentially conflicting dependency to test if shadow jar works
    implementation("io.opentelemetry:opentelemetry-sdk:1.1.0")

    implementation("com.fluxninja.aperture:aperture-java:0.4.0-SNAPSHOT") {
        attributes {
            attribute(Bundling.BUNDLING_ATTRIBUTE, objects.named(Bundling::class.java, Bundling.SHADOWED))
        }
    }
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}
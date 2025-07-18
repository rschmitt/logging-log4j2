plugins {
    application
}

repositories {
    mavenCentral()
    mavenLocal()
}

val ver = System.getenv("VER") ?: "2.25.1"

dependencies {
    implementation("org.apache.logging.log4j:log4j-api:$ver")
    runtimeOnly("org.apache.logging.log4j:log4j-core:$ver")
    runtimeOnly("org.apache.logging.log4j:log4j-1.2-api:$ver")

    testImplementation(libs.junit.jupiter)
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

application {
    mainClass = "org.example.App"
}

tasks.register<JavaExec>("badLog4j1") {
    group = "application"
    isIgnoreExitValue = true
    classpath = sourceSets.main.get().runtimeClasspath
    mainClass.set(application.mainClass)
    systemProperty("log4j.configuration", "bad-config.properties")
}

tasks.register<JavaExec>("badLog4j2") {
    group = "application"
    isIgnoreExitValue = true
    classpath = sourceSets.main.get().runtimeClasspath
    mainClass.set(application.mainClass)
    systemProperty("log4j.configurationFile", "bad-config.properties")
}

tasks.register<JavaExec>("wrongVersion") {
    group = "application"
    isIgnoreExitValue = true
    classpath = sourceSets.main.get().runtimeClasspath
    mainClass.set(application.mainClass)
    systemProperty("log4j.configurationFile", "valid-log4j1-config.properties")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

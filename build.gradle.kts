
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

tasks.named<Test>("test") {
    useJUnitPlatform()
}

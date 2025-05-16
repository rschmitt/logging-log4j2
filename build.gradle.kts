
plugins {
    application
}

repositories {
    mavenCentral()
    mavenLocal()
}

val ver = System.getenv("VER") ?: "2.24.3"

dependencies {
    implementation("org.apache.logging.log4j:log4j-api:$ver")
    implementation("org.apache.logging.log4j:log4j-core:$ver")
    implementation("org.apache.logging.log4j:log4j-1.2-api:$ver")

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

plugins {
    id("java")
}

group = "com.nisum.service"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.5.2")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.5.2")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.5.2")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.5.2")
    testImplementation("org.junit.platform:junit-platform-commons:1.5.2")
    testImplementation("org.junit.platform:junit-platform-engine:1.5.2")
    testImplementation("org.mockito:mockito-junit-jupiter:3.1.0")
    testImplementation("org.mockito:mockito-core:3.1.0")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

plugins {
	java
}

tasks.withType<Test> {
	useJUnitPlatform()
}

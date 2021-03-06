import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
plugins {
	id("org.springframework.boot") version "2.4.0"
	id("io.spring.dependency-management") version "1.0.10.RELEASE"
	kotlin("jvm") version "1.4.10"
	kotlin("plugin.spring") version "1.4.10"
	  kotlin("plugin.allopen") version "1.3.61"

}
group = "org.stittlem"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11
repositories {
	mavenCentral()
}


allOpen {
  annotation("org.springframework.data.mongodb.core.mapping.Document")
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-mustache")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
  implementation("org.springframework.boot:spring-boot-starter-data-mongodb")

	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

testImplementation("org.springframework.boot:spring-boot-starter-test") {
  exclude(module = "junit")
  exclude(module = "mockito-core")
}
testImplementation("org.junit.jupiter:junit-jupiter-api")
testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
testImplementation("com.ninja-squad:springmockk:1.1.3")

  testImplementation("de.flapdoodle.embed:de.flapdoodle.embed.mongo")
  //testImplementation("org.testcontainers:junit-jupiter")
  //testImplementation("org.testcontainers:mongodb")

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

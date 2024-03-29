plugins {
  kotlin("jvm") version "1.9.20"
  id("org.jetbrains.dokka") version "1.9.10"
  `java-library`
  `maven-publish`
}

group = "org.veupathdb.lib"
version = "6.0.1"

java {
  targetCompatibility = JavaVersion.VERSION_16
  sourceCompatibility = JavaVersion.VERSION_16

  withSourcesJar()
  withJavadocJar()
}

allprojects {
  repositories {
    mavenLocal()
    mavenCentral()
    maven {
      name = "GitHubPackages"
      url = uri("https://maven.pkg.github.com/veupathdb/packages")
      credentials {
        username = project.findProperty("gpr.user") as String? ?: System.getenv("GITHUB_USERNAME")
        password = project.findProperty("gpr.key") as String? ?: System.getenv("GITHUB_TOKEN")
      }
    }
  }
}

repositories {
  mavenCentral()
}

tasks.dokkaHtml {
  outputDirectory.set(rootDir.resolve("docs/dokka"))
}

tasks.dokkaJavadoc {
  outputDirectory.set(rootDir.resolve("docs/javadoc"))
}

dependencies {
  api("org.veupathdb.lib:jackson-singleton:3.1.1")

  testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
  testImplementation("org.junit.jupiter:junit-jupiter-params:5.8.2")
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")
}

tasks.jar {
  manifest {
    attributes["Implementation-Title"] = project.name
    attributes["Implementation-Version"] = project.version
  }
}

tasks.withType<Test> {
  useJUnitPlatform()
  testLogging {
    events.addAll(listOf(org.gradle.api.tasks.testing.logging.TestLogEvent.FAILED,
      org.gradle.api.tasks.testing.logging.TestLogEvent.SKIPPED,
      org.gradle.api.tasks.testing.logging.TestLogEvent.STANDARD_OUT,
      org.gradle.api.tasks.testing.logging.TestLogEvent.STANDARD_ERROR,
      org.gradle.api.tasks.testing.logging.TestLogEvent.PASSED))

    exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
    showExceptions = true
    showCauses = true
    showStackTraces = true
    showStandardStreams = true
    enableAssertions = true
  }
  ignoreFailures = true // Always try to run all tests for all modules
}


publishing {
  repositories {
    maven {
      name = "GitHub"
      url = uri("https://maven.pkg.github.com/VEuPathDB/lib-jvm-blast")
      credentials {
        username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
        password = project.findProperty("gpr.key") as String? ?: System.getenv("TOKEN")
      }
    }
  }

  publications {
    create<MavenPublication>("gpr") {
      from(components["java"])
      pom {
        name.set("Blast CLI/JSON Library")
        description.set("Provides a set of types representing blast tool configurations.")
        url.set("https://github.com/VEuPathDB/lib-java-blast")
        developers {
          developer {
            id.set("epharper")
            name.set("Elizabeth Paige Harper")
            email.set("epharper@upenn.edu")
            url.set("https://github.com/foxcapades")
            organization.set("VEuPathDB")
          }
        }
        scm {
          connection.set("scm:git:git://github.com/VEuPathDB/lib-java-blast.git")
          developerConnection.set("scm:git:ssh://github.com/VEuPathDB/lib-java-blast.git")
          url.set("https://github.com/VEuPathDB/lib-java-blast")
        }
      }
    }
  }
}

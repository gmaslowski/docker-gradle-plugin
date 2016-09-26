docker-gradle-plugin
====================

## Example
```gradle
buildscript {
  repositories {
    maven {
      url "https://plugins.gradle.org/m2/"
    }
  }
  dependencies {
    classpath "gradle.plugin.com.gmaslowski.gradle.plugin.docker:docker-gradle-plugin:0.2"
  }
}

apply plugin: "com.gmaslowski.gradle.plugin.docker"

docker {
    workingDir = "$buildDir/docker"
    tags = ["group/name:version"]
    dockerfile = "$projectDir/src/main/docker/Dockerfile"
    files = ["jarfile.jar", "otherneededfile"]
}
```

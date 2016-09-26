docker-gradle-plugin
====================

## Example
```groovy
plugins {
  id "com.gmaslowski.gradle.plugin.docker" version "0.2"
}

docker {
    workingDir = "$buildDir/docker"
    tags = ["group/name:version"]
    dockerfile = "$projectDir/src/main/docker/Dockerfile"
    files = ["jarfile.jar", "otherneededfile"]
}
```
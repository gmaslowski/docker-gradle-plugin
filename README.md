docker-gradle-plugin
====================

## Example
```
plugins {
  id "com.gmaslowski.gradle.plugin.docker" version "0.1"
}

docker {
    workingDir = "$buildDir/docker"
    tag = "group/name:version"
    dockerfile = "$projectDir/src/main/docker/Dockerfile"
    files = ["jarfile.jar", "otherneededfile"]
}
```
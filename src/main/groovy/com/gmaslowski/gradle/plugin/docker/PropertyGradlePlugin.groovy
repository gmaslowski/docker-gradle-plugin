package com.gmaslowski.gradle.plugin.docker

import org.gradle.api.Plugin
import org.gradle.api.Project

class DockerGradlePlugin implements Plugin<Project> {
    void apply(Project project) {

        project.extensions.create("docker", DockerGradlePluginExtension)

        project.task('buildDocker') << {
            project.docker.files.each { file ->
                project.copy {
                    from file
                    into project.docker.workingDir
                }
            }
            project.copy {
                from project.docker.dockerfile
                into project.docker.workingDir
            }

            project.exec {
                workingDir project.docker.workingDir
                commandLine 'docker', 'build', '--pull=true', '-t', project.docker.tag, project.docker.workingDir
            }
        }
    }
}

class DockerGradlePluginExtension {
    String workingDir
    String tag
    String dockerfile
    String[] files
}
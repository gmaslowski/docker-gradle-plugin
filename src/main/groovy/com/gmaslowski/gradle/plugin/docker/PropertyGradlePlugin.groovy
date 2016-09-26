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

                def arguments = ['docker', 'build', '--pull=true']
                project.docker.tags.each { arguments.addAll(["-t", it])}
                arguments.add(project.docker.workingDir)

                commandLine arguments
            }
        }
    }
}

class DockerGradlePluginExtension {
    String workingDir
    String[] tags
    String dockerfile
    String[] files
}
#!/usr/bin/env groovy
package com.mooji

/** Shared-library helper for Docker image build and push operations. */
class Docker implements Serializable {
    private static final long serialVersionUID = 1L
    def script

    Docker(script) {
        this.script = script
    }

    /**
     * Publishes a Docker image to the configured registry.
     * @param imageName fully qualified image name and tag
     */
    def publishImage(String imageName) {
        script.echo "Building Docker image: ${imageName}"
        script.withCredentials([
            usernamePassword(
                credentialsId: 'docker-hub-credentials',
                usernameVariable: 'USERNAME',
                passwordVariable: 'PASSWORD'
            )
        ]) {
            script.sh "docker build -t ${imageName} ."
            script.sh "echo ${script.PASSWORD} | docker login -u ${script.USERNAME} --password-stdin"
            script.sh "docker push ${imageName}"
        }
    }
}
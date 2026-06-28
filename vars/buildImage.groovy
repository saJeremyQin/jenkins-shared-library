#!/usr/bin/env groovy

import com.mooji.Docker

def call(String imageName) {
    def docker = new Docker(this)
    docker.publishImage(imageName)
}

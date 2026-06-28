#!/usr/bin/env groovy

def call(String branchName) {
    echo "building the application for $branchName branch"
    sh 'mvn package'
}
#!/usr/bin/env groovy

def call(String BRANCH_NAME) {
    echo "building the application for $BRANCH_NAME branch"
    sh 'mvn package'
}
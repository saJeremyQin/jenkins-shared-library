#!/usr/bin/env groovy

def call(String status) {
    echo "----------------------------------------"
    echo "LOG: The current build status is: ${status}"
    echo "----------------------------------------"
}

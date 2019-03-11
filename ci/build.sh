#!/usr/bin/env bash

M2_HOME="/root/.m2"
M2_CACHE="$(pwd)/maven-config"

ln -s ${M2_CACHE} ${M2_HOME}

mvn clean install -f sources

cp -R sources/target/*.jar build_output/

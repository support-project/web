#! /bin/bash
mvn clean deploy -DperformRelease=true -Dmaven.javadoc.skip=true -e

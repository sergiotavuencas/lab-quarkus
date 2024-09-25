#!/bin/bash -xe
APP=$1
ROOT=$(pwd)

cd "$APP"

mvn clean
mvn versions:set -DremoveSnapshot
APP_VERSION=$(mvn -q -Dexec.executable=echo -Dexec.args='${project.version}' --non-recursive exec:exec)
mvn package
mvn versions:set -DnextSnapshot

git add pom.xml
git commit -m "cicd: bump version ${APP}:${APP_VERSION}"

cd "$ROOT"
TAG=$APP_VERSION docker compose build --no-cache "$APP"

docker images "dio/${APP}"

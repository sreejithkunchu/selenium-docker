FROM openjdk:8u191-jre-alpine3.8

RUN apk add curl jq

WORKDIR /selenium-docker

ADD target/selenium-docker-tests.jar selenium-docker-tests.jar
ADD target/selenium-docker.jar selenium-docker.jar
ADD target/libs libs
ADD searchmoduleBy.xml searchmoduleBy.xml
ADD searchmodule.xml searchmodule.xml


ADD healthcheck.sh healthcheck.sh


ENTRYPOINT sh healthcheck.sh
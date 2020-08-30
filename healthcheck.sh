#!/usr/bin/env bash

echo "checking if the hub is ready - $HUB_HOST"

while [[ "$(curl -s http://$HUB_HOST:4444/wd/hub/status | jq -r .value.ready)" != "true" ]]; do
    sleep 1
done

java -cp selenium-docker-tests.jar:selenium-docker.jar:libs/* -DBROWSER=$BROWSER -DHUB_HOST=$HUB_HOST org.testng.TestNG $MODULE
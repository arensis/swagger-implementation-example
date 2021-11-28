#!/bin/bash

docker run --name swaggerexample -e MYSQL_ROOT_PASSWORD=alfonsomadrid -e MYSQL_USER=powereduser -e MYSQL_PASSWORD=password -e MYSQL_DATABASE=starwarsplanets -d -p 3306:3306 mysql



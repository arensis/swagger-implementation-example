#!/bin/bash

docker exec -i swaggerexample sh -c 'mysqldump -uroot -p"alfonsomadrid" starwarsplanets' > dump.sql

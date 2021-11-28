#!/bin/bash

sh startDatabase.sh

echo 'Waiting to container generation'
sleep 30s &
PID=$!
i=1
sp="/-\|"
echo -n ' '

while [ -d /proc/$PID ]
do
  printf "\b${sp:i++%${#sp}:1}"
done

echo 'Container load finished, populating database'
docker exec -i swaggerexample sh -c 'mysql -uroot -p"alfonsomadrid" starwarsplanets' < databasedump/dump.sql
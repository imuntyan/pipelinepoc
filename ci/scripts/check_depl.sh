#!/bin/sh

interval=10
((end_time=${SECONDS}+60))

while ((${SECONDS} < ${end_time}))
do
  response=$(curl --write-out %{http_code} --silent --output /dev/null $1)
  if [ ${response} == "200" ]
  then
    echo "status returned 200"
    exit 0
  fi
  sleep ${interval}
done

echo "No 200 response"
exit 1
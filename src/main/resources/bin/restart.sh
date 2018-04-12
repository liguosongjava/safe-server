#!/bin/bash
cd `dirname $0`

ALL_ENV=("dev" "product")
if [ -z "$1" ] ;then
    echo "you have not input a env!"
    echo ${ALL_ENV[@]}
    exit 1
fi

ENV=$1
if echo "${ALL_ENV[@]}" | grep -v "$ENV" &>/dev/null; then
    echo "not in env"
    echo ${ALL_ENV[@]}
    exit 1
fi

cd  ..

sh bin/stop.sh
sh bin/start.sh $ENV
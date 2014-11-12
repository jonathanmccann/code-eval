#!/bin/bash

while read -r LINE || [[ -n $LINE ]]; do
	echo $LINE | awk '{print $(NF - 1)}'
done < $1
#!/bin/bash

while read -r LINE || [[ -n $LINE ]]; do
	LINE=$(echo $LINE | grep -io '[0-9]*' | sort -nu)

	echo $LINE| tr ' ' ','
done < $1
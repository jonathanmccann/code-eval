#!/bin/bash

IFS=","

while read -r LINE || [[ -n $LINE ]]; do
	INPUT_ARRAY=($LINE)

	echo $((${INPUT_ARRAY[0]} % ${INPUT_ARRAY[1]}))
done < $1
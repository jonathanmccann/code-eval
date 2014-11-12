#!/bin/bash

IFS=","

while read -r LINE || [[ -n $LINE ]]; do
	INPUT_ARRAY=($LINE)

	echo ${INPUT_ARRAY[0]} | awk -F "${INPUT_ARRAY[1]}" '{print length($0) - length($NF) - 1}'
done < $1
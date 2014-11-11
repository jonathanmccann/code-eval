#!/bin/bash

IFS=","

while read -r LINE || [[ -n $LINE ]]; do
	INPUT_ARRAY=($LINE)

	SUM=${INPUT_ARRAY[1]}

	while [[ $SUM -lt ${INPUT_ARRAY[0]} ]]; do
		((SUM=$SUM+${INPUT_ARRAY[1]}))
	done

	echo $SUM
done < $1
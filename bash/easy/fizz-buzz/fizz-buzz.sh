#!/bin/bash

while read -r LINE || [[ -n $LINE ]]; do
	INPUT_ARRAY=($LINE)

	COUNT=${INPUT_ARRAY[2]}

	for ((i = 1; i <= $COUNT; i++)); do
		if [[ $(($i % ${INPUT_ARRAY[0]})) -eq 0 ]] && [[ $(($i % ${INPUT_ARRAY[1]})) -eq 0 ]]
		then
			echo -n FB
		elif [[ $(($i % ${INPUT_ARRAY[0]})) -eq 0 ]]
		then
			echo -n F
		elif [[ $(($i % ${INPUT_ARRAY[1]})) -eq 0 ]]
		then
			echo -n B
		else
			echo -n $i
		fi

		if [[ $i -lt $COUNT ]]
		then
			echo -n " "
		fi
	done

	echo
done < $1
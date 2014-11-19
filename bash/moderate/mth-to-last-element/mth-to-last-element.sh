#!/bin/bash

while read -r LINE || [[ -n $LINE ]]; do
	INPUT_ARRAY=($LINE)

	if [[ ${INPUT_ARRAY[${#INPUT_ARRAY[@]}-1]} -lt ${#INPUT_ARRAY[@]} ]]
	then
		OUTPUT=${INPUT_ARRAY[$((${#INPUT_ARRAY[@]} - ${INPUT_ARRAY[${#INPUT_ARRAY[@]}-1]} - 1))]}

		echo $OUTPUT
	fi
done < $1
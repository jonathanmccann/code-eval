#!/bin/bash

while read -r LINE || [[ -n $LINE ]]; do
	WORD_ARRAY=($LINE)

	for ((i = ${#WORD_ARRAY[@]} - 1; i >= 0; i--)); do
		echo -n ${WORD_ARRAY[i]}

		if [[ i > 0 ]]
		then
			echo -n " "
		fi
	done

	echo
done < $1
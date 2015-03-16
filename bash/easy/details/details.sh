#!/bin/bash

IFS=","

while read -r LINE || [[ -n $LINE ]]; do
	INPUT_ARRAY=($LINE)

	NUMBER_OF_CELLS_TO_MOVE=10;

	for i in "${INPUT_ARRAY[@]}"
	do
		CAVITY_SPACE=(`echo ${i} | grep -io 'X\.*Y' | sed 's/^X//; s/.$//'`)

		if [[ ${#CAVITY_SPACE} -eq 0 ]]
		then
			NUMBER_OF_CELLS_TO_MOVE=0
			break
		elif [[ ${#CAVITY_SPACE} -lt ${NUMBER_OF_CELLS_TO_MOVE} ]]
		then
			NUMBER_OF_CELLS_TO_MOVE=${#CAVITY_SPACE}
		fi
	done

	echo $NUMBER_OF_CELLS_TO_MOVE
done < $1
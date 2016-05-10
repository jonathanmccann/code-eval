#!/bin/bash

while read -r LINE || [[ -n $LINE ]]; do
	DEVELOPER=(`echo $LINE | awk -F"|" '{gsub(/[ \t]+$/,"",$1); print $1}' | grep -o .`)

	DESIGN=(`echo $LINE | awk -F"|" '{gsub(/^[ \t]+/,"",$2); print $2}' | grep -o .`)

	COUNT=0

	for ((i = 0; i < ${#DEVELOPER[@]}; i++)); do
		if [ "${DEVELOPER[$i]}" != "${DESIGN[$i]}" ]
		then
			let COUNT=$((COUNT + 1))
		fi
	done

	if (( $COUNT == 0 ))
	then
		echo Done
	elif (( $COUNT <= 2 ))
	then
		echo Low
	elif (( $COUNT <= 4 ))
	then
		echo Medium
	elif (( $COUNT <= 6 ))
	then
		echo High
	else
		echo Critical
	fi
done < $1
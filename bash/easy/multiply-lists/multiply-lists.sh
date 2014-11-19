#!/bin/bash

while read -r LINE || [[ -n $LINE ]]; do
	FIRST_LIST=(`echo $LINE | awk -F'|' '{print $1}'`)

	SECOND_LIST=(`echo $LINE | awk -F'|' '{print $2}'`)

	OUTPUT_ARRAY=()

	for ((i = 0; i < ${#FIRST_LIST[@]}; i++)); do
		OUTPUT_ARRAY+=($((${FIRST_LIST[$i]} * ${SECOND_LIST[$i]})))
	done

	echo ${OUTPUT_ARRAY[@]}
done < $1
#!/bin/bash

while read -r LINE || [[ -n $LINE ]]; do
	TIMESTAMPS=($LINE)

	IFS=$'\n'

	SORTED_TIMESTAMPS=($(sort -r <<< "${TIMESTAMPS[*]}"))

	unset IFS

	echo ${SORTED_TIMESTAMPS[*]}
done < $1
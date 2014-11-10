#!/bin/bash

while read -r LINE || [[ -n $LINE ]]; do
    NUMBER_SIZE=${#LINE}

    DIGITS=$(echo $LINE | sed -e 's/\(.\)/\1\n/g')

    TOTAL_SUM=0

    for DIGIT in $DIGITS ; do
		TOTAL_SUM=`expr $TOTAL_SUM + $(($DIGIT**$NUMBER_SIZE))`
	done

	if [[ $TOTAL_SUM == $LINE ]]
	then
		echo "True"
	else
		echo "False"
	fi
done < $1
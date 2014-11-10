#!/bin/bash

while read -r LINE || [[ -n $LINE ]]; do
	DIGITS=$(echo $LINE | sed -e 's/\(.\)/\1\n/g')

	SUM=0

	for DIGIT in $DIGITS; do
		let SUM=$SUM+$DIGIT
	done

	echo $SUM
done < $1
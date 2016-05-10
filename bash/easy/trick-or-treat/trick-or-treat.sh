#!/bin/bash

while read -r LINE || [[ -n $LINE ]]; do
	DIGITS_ARRAY=($(echo $LINE | grep -o "[0-9]\+"))

	NUMBER_OF_CHILDREN=$((${DIGITS_ARRAY[0]} + ${DIGITS_ARRAY[1]} + ${DIGITS_ARRAY[2]}))

	NUMBER_OF_CANDY=$((${DIGITS_ARRAY[3]} * ((${DIGITS_ARRAY[0]} * 3) + (${DIGITS_ARRAY[1]} * 4) + (${DIGITS_ARRAY[2]} * 5))))

	echo $(($NUMBER_OF_CANDY / $NUMBER_OF_CHILDREN))
done < $1
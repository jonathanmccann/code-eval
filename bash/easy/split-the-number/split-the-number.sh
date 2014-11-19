#!/bin/bash

while read -r LINE || [[ -n $LINE ]]; do
	INPUT_ARRAY=($LINE)

	POSITION=`expr index "${INPUT_ARRAY[1]}" "\+"`

	if [[ $POSITION -eq 0 ]]
	then
		POSITION=`expr index "${INPUT_ARRAY[1]}" "\-"`
		OPERATOR="-"
	else
		OPERATOR="+"
	fi

	FIRST_NUMBER=${INPUT_ARRAY[0]:0:$POSITION-1}
	SECOND_NUMBER=${INPUT_ARRAY[0]:$POSITION-1}

	echo $FIRST_NUMBER $OPERATOR $SECOND_NUMBER | bc
done < $1
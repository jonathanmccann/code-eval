#!/bin/bash

while read -r LINE || [[ -n $LINE ]]; do
	PLAYERS=(`echo $LINE | awk -F'|' '{print $1}'`)

	BLACK_SPOT_NUMBER=(`echo $LINE | awk -F'|' '{print $2}'`)

	while [ ${#PLAYERS[@]} -gt 1 ]; do
		REMOVAL_NUMBER=$((BLACK_SPOT_NUMBER % ${#PLAYERS[@]}))

		if [[ ! "$REMOVAL_NUMBER" > 0 ]]
		then
			REMOVAL_NUMBER=$((${#PLAYERS[@]} - $REMOVAL_NUMBER))
		fi

		PLAYERS=(${PLAYERS[@]:0:$REMOVAL_NUMBER - 1} ${PLAYERS[@]:$REMOVAL_NUMBER})
	done

	echo $PLAYERS
done < $1
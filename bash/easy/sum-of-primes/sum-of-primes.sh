#!/bin/bash

COUNTER=1
SUM_OF_PRIMES=2
PRIME_CANDIDATE=3

while [[ $COUNTER -lt 1000 ]]; do
	IS_PRIME="true"

	for ((j = 3; $(($j * $j)) <= $PRIME_CANDIDATE; j+=2)); do
		if [[ $(($PRIME_CANDIDATE % $j)) -eq 0 ]]
		then
			IS_PRIME="false"
			break
		fi
	done

	if [[ "$IS_PRIME" == "true" ]]
	then
		let SUM_OF_PRIMES="$SUM_OF_PRIMES + $PRIME_CANDIDATE"
		let COUNTER="$COUNTER + 1"
	fi

	let PRIME_CANDIDATE="$PRIME_CANDIDATE + 2"
done

echo $SUM_OF_PRIMES
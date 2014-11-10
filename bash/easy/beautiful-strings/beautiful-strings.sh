#!/bin/bash

while read -r LINE || [[ -n $LINE ]]; do
	# Strip out non-alpha characters
	LINE=${LINE//[^[:alpha:]]/}

	# Convert the string to lower case
	LINE=${LINE,,}

	# Get individual characters in the string and sort them by number of
	# occurences
	CHARACTERS=$(echo $LINE | grep -o . | sort -S 1000 | uniq -c | sort -nr)

	# Only retain the count from the unique list
	DIGITS=$(echo $CHARACTERS | grep -io '[0-9]*')

	BEAUTY=0;
	VALUE=26;

	for DIGIT in $DIGITS; do
		let BEAUTY="$BEAUTY + $(($VALUE*$DIGIT))"

		let VALUE="$VALUE - 1"
	done

	echo $BEAUTY
done < $1
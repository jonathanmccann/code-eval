#!/bin/bash

while read -r LINE || [[ -n $LINE ]]; do
	LINE_ARRAY=($LINE)

	echo "${LINE_ARRAY[*]^}"
done < $1
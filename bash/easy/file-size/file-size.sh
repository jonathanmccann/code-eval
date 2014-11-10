#!/bin/bash

while read -r LINE || [[ -n $LINE ]]; do
	echo $(stat -c%s "$LINE")
done < $1
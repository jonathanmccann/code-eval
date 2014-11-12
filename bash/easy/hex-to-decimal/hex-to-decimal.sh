#!/bin/bash

while read -r LINE || [[ -n $LINE ]]; do
	echo "ibase=16; ${LINE^^}" | bc
done < $1
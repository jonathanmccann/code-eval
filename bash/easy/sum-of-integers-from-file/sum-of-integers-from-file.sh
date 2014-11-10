#!/bin/bash

SUM=0

while read -r LINE || [[ -n $LINE ]]; do
	let SUM=$SUM+$LINE
done < $1

echo $SUM
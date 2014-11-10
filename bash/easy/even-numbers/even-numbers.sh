#!/bin/bash

while read -r LINE || [[ -n $LINE ]]; do
	echo $(($(($LINE % 2)) == 0))
done < $1
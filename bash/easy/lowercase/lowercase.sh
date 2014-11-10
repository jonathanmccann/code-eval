#!/bin/bash

while read -r LINE || [[ -n $LINE ]]; do
	echo ${LINE,,}
done < $1
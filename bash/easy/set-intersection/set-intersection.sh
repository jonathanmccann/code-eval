#!/bin/bash

while read -r LINE || [[ -n $LINE ]]; do
	echo `echo $LINE | tr ',;' '\n' | sort | uniq -d | sed ':a;N;$!ba;s/\n/,/g'`
done < $1
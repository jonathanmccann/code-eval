while read -r LINE || [[ -n $LINE ]]; do
    if (( "$LINE" < 0 || "$LINE" > 100))
	then
		echo "This program is for humans"
	elif (( "$LINE" <= 2 ))
	then
		echo "Still in Mama's arms"
	elif (( "$LINE" <= 4 ))
	then
		echo "Preschool Maniac"
	elif (( "$LINE" <= 11 ))
	then
		echo "Elementary school"
	elif (( "$LINE" <= 14 ))
	then
		echo "Middle school"
	elif (( "$LINE" <= 18 ))
	then
		echo "High school"
	elif (( "$LINE" <= 22 ))
	then
		echo "College"
	elif (( "$LINE" <= 65 ))
	then
		echo "Working for the man"
	else
		echo "The Golden Years"
	fi
done < $1
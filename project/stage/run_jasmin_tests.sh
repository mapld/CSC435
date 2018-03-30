make clean
make

for f in tests/accept/*.ul
do
    java Compiler $f 2>&1
done

jasmin_success_counter=0;
jasmin_fail_counter=0;
echo -e "${BLUE}Compiling .j files and running then to compare against expected output"
for f in tests/j/*.j
do
    FIRST_OUTPUT="$(java jasmin.Main $f)"
    if [[ -n "$FIRST_OUTPUT" ]]
    then
        echo -e "${RED}problem with $f"
        echo -e "${RED}${FIRST_OUTPUT}"
    else
        f_basename="$(basename $f .j)"
        FIRST_OUTPUT=$(java $f_basename 2>&1)
        SECOND_OUTPUT=$(./codegen --file=tests/ir/$f_basename.ir > tmp.j)
        SECOND_OUTPUT=$(java jasmin.Main tmp.j)
        SECOND_OUTPUT=$(java $f_basename)
        echo "$FIRST_OUTPUT" > tmp.out
        echo "$SECOND_OUTPUT" > tmp2.out
        DIFF_OUTPUT="$(diff --ignore-all-space tmp.out tmp2.out)"
        if [[ -n "$DIFF_OUTPUT" ]];
        then
            jasmin_fail_counter=$((jasmin_fail_counter+1))
            echo -e "${RED} differences in expected output and final output of $f_basename"
            echo -e "${RED}${DIFF_OUTPUT}"
        else
            echo -e "${GREEN} success running $f_basename"
        fi
    fi

done



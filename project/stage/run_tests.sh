ESCAPE_SEQUENCE="\x1b["
RESET_COLOR=$ESCAPE_SEQUENCE"39;49;00m"
BLUE=$ESCAPE_SEQUENCE"34;01m"
RED=$ESCAPE_SEQUENCE"31;01m"
GREEN=$ESCAPE_SEQUENCE"32;01m"

echo -e "${BLUE}Creating compiler"
echo -e "$RESET_COLOR"
make clean
make
echo -e "${BLUE}Compiling tests"
echo -e "${BLUE}Running tests that should be accepted"
success_counter=0;
fail_counter=0;
FAIL=""
for f in tests/accept/*.ul
do
    OUTPUT="$(java Compiler $f 2>&1)"
    if [ -z "$OUTPUT" ]
    then
        success_counter=$((success_counter+1))
        echo -e "${GREEN}Accepted $f"
    else
        fail_counter=$((fail_counter+1))
        echo -e "${RED}Failed compiling $f with errors: "
        echo -e "${RED}${OUTPUT}"
    fi
done

if [ $fail_counter -gt 0 ]
then
    FAIL="${RED} and $fail_counter failed tests"
fi
echo -e "${GREEN}Ran $success_counter successful tests $FAIL"

echo -e "${BLUE}Running tests that should be rejected"


reject_counter=0
reject_fail_counter=0
for f in tests/reject/*.ul
do
    OUTPUT="$(java Compiler $f 2>&1)"
    if [ -z "$OUTPUT" ]
    then
        reject_fail_counter=$((reject_fail_counter+1))
        echo -e "${RED} Failed to reject $f"
    else
        reject_counter=$((reject_counter+1))
        echo -e "${GREEN} Rejected $f with message:"
        echo -e "${RESET_COLOR}$OUTPUT"
    fi
done

REJECT_FAIL=""
if [ $reject_fail_counter -gt 0 ]
then
    REJECT_FAIL="${RED} and failed to reject $reject_fail_counter tests"
fi

echo -e "${GREEN}Rejected $reject_counter tests properly $REJECT_FAIL"

echo -e "${BLUE}Matching pretty print results against originals"

pretty_counter=0
pretty_fail_counter=0
for f in tests/pretty/*.ul
do
    OUTPUT="$(java PrettyPrinter $f | diff $f - 2>&1)"
    if [ -z "$OUTPUT" ]
    then
        pretty_counter=$((success_counter+1))
        echo -e "${GREEN}Pretty print matches $f"
    else
        pretty_fail_counter=$((fail_counter+1))
        echo -e "${RED}Mismatch in pretty print for $f"
        echo -e "${RED}${OUTPUT}"
    fi
done

echo -e "${BLUE}Checking IR"
ir_success_counter=0;
ir_fail_counter=0;
FAIL=""
for f in tests/ir/*.ir
do
    C_OUTPUT="$(./codegen --file=$f > tmp.j)"
    J_OUTPUT="$(java jasmin.Main tmp.j 2>&1)"
    if [[ -z "$C_OUTPUT" ]] && [[ -z "$J_OUTPUT" ]];
    then
        ir_success_counter=$((ir_success_counter+1))
        echo -e "${GREEN}IR in $f read successfully"
    else
        ir_fail_counter=$((ir_fail_counter+1))
        echo -e "${RED}Failed to parse $f with errors: "
        echo -e "${RED}${C_OUTPUT}"
        echo -e "${RED}${J_OUTPUT}"
    fi
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



if [ $fail_counter -eq 0 -a $reject_fail_counter -eq 0 -a $pretty_fail_counter -eq 0 -a $ir_fail_counter -eq 0 -a $ir_fail_counter -eq 0 ]
then
    echo -e "${BLUE}Tests ran - ${GREEN}Success!"
else
    echo -e "${BLUE}Tests ran - ${RED}Failed"
fi

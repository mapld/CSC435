for f in tests/pretty/*.ul
do
    java PrettyPrinter $f > tmp.ul
    cat tmp.ul > $f
done
rm tmp.ul

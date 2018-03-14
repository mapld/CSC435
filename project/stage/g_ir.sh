git pull
make
java Compiler tests/accept/basic.ul
java Compiler tests/accept/basic.ul > test.ir
~/codegen --file=test.ir > test.j
java jasmin.Main test.j
java test

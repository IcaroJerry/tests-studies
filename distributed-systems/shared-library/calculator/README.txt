Compile:

1: $ gcc -c -Wall -Werror -fpic calculator.c
2: $ gcc -shared -o libcalculator.so calculator.o
3: $ gcc -L. -Wall -o exec main.c -lcalculator
4: $ gcc -L. -Wl,-rpath=. -Wall -o exec main.c -lcalculator
5: $ ./exec

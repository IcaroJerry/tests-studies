#include <stdio.h>
#include "calculator.h"
 
int main(void)
{
        printf("This is a shared library test...\n");
       	cal();
	printf("\n");

	printf("1+2 is:");
	plus(1,2);
	printf("\n");

	printf("2-2 is:");
	minus(2,2);
	printf("\n");

	return 0;
}

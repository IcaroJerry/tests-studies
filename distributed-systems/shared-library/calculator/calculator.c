#include <stdio.h>
 
 
void cal(void)
{
    printf("Hello, I'm a shared library");
}

void plus(int a, int b)
{
    int result = a+b;
    printf("%d",result);
}

void minus(int a, int b)
{
    int result = a-b;
    printf("%d",result);
}

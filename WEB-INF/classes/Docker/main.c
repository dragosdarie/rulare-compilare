#include <string.h>
#include <stdio.h>
#include <stdlib.h>

int main ()
{

int number1, number2, sum;
int al;
FILE *fis;
fis = fopen("suma.in","r");

fscanf(fis, "%d", &number1);
fscanf(fis, "%d", &number2);
sum = number1 + number2;
printf("%d", sum);
fclose(fis);
return 0;
}


#include <stdio.h>
int main()
{
   // printf() displays the string inside quotation
   printf("sal!\n");
   FILE *f =fopen("test123.txt", "w");
   fprintf(f, "Write succesful!\n");
   fclose(f);
   return 0;
}

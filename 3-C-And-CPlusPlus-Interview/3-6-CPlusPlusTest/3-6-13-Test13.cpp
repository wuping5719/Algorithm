#include "stdafx.h"
void fun(char *s, char c)
{
  int i, j, n;
  for(i=0; s[i]!='\0';i++)
  {
    if(s[i]==c)
    {
       n = 0 ;
       while(s[i+1+n]!='\0')
       n++;
       for(j=i+n+1;j>i;j--)
         s[j + 1] = s[j];

       s[j+1]=c ;
       i=i+1;
    }
  }
}

void main()
{
   char s[80] = "baacda", c;
   printf("\nThe string:% s\n", s);
   printf("\nInput a character:");
   scanf("%c",&c);
   fun(s, c);
   printf("\nThe result is:%s\n", s);
}

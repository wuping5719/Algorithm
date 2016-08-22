#include "stdafx.h"
#include <stdio.h>

int fun(int x)
{
   int n, s1, s2, s3, t;
   /**********found**********/
   n = 0 ;
   t = 100;
   /**********found**********/
   while(t<=x)
  {
    s1 = t % 10;
    s2 = (t / 10) % 10;
    s3 = t / 100;
    if (s1 + s2 + s3 == 15)
    {     
		printf("% d", t);
        n++; 
	 }
	t++;
  }
  return n;
}

int main( )
{
   int x = -1;
   while(x>999 || x<0)
   {
     printf("Please input(0 < x <=999):");
     scanf ("%d", &x);
   }
   printf ("\nThe result is: %d\n",fun(x));
}

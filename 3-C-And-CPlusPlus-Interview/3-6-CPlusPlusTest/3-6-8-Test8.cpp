#include "stdafx.h"
#include <stdio.h>
int main()
{  
   int a=1,b=2,c=3,d=0;
   if(a == 1 && b++==2)
    if(b!=2||c--!=3)
       printf("%d,%d,%d\n" ,a,b,c);
    else
       printf("%d,%d,%d\n" ,a,b,c);
   else
       printf("%d,%d,%d\n" ,a,b,c);
   return 0;
}

#include "stdafx.h"
#include <stdio.h>

int _tmain(int argc, _TCHAR* argv[])
{
	char c[2] [5]={ "6934", "8254"},* p[2];
    int i, j, s=0;
    for(i=0;i<2;i++) 
        p[i]=c[i];
    for(i=0;i<2;i++)  
    for(j=0;p[i][j]>0&&p[i][j]<='9';j+=2)
      s=10*s+p[i][j]-'0';
    printf("%d\n",s);
	return 0;
}

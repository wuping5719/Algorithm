#include "stdafx.h"
#include<stdio.h>
#include<stdlib.h>

void fun (int *s)
{
    static int j=0;
    do {
        s[j] += s[j+1];
    }while(++j<2);
}

int _tmain(int argc, _TCHAR* argv[])
{
	int i, a[10]={1,2,3,4,5};
    for(i=1; i<3; i++) 
		fun(a);
    for(i=1; i<5; i++)
		printf("%d",a[i]);
    printf("\n");
	system("pause");
	return 0;
}


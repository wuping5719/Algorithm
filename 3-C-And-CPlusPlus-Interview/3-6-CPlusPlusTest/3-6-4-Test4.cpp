#include "stdafx.h"
#include<stdio.h>
#include<stdlib.h>

void main()
{
	int a=-3;
	unsigned int b=2;
	long c=a+b;
	printf("%ld\n",c);

	int x=10;
    int y=10;
    x=y=++y;
    printf("%d %d",x,y);
}

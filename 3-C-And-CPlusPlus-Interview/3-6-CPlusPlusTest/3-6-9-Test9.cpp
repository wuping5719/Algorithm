#include "stdafx.h"
#include <stdio.h>
#include <iostream>
using namespace std;
static int a=1;
void fun1(void){    
	a=2;  
}
void fun2(void){    
	int a=3;  
}
void fun3(void){   
	static int a=4;  
}
void main(int argc,char** args){ 
     printf("%d",a); 
     fun1(); 
     printf("%d",a); 
     fun2(); 
     printf("%d",a);
     fun3();
     printf("%d",a); 

	 char *p1="123", *p2="ABC", str[50]="xyz";
     strcpy(str+2,strcat(p1,p2));
     cout<<str;
}

int miracle(unsigned int n)
{ 
    int m=n==0?0:1;
    while (n=(n&(n-1)))
    {
      m++;
    }
    return m;
}

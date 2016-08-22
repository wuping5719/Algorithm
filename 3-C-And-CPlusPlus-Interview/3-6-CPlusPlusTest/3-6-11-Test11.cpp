#include "stdafx.h"
#include <stdio.h>
#include <iostream>
using namespace std;

void main(){
    int x =35,B;
    char z ='B';
    B =((x)&&(z<'b'));
    printf("%d\n",B);

	char ccString1[]="Is Page Fault??";
    char ccString2[]="No Page Fault??";
    strcpy(ccString1,"No");
    if(strcmp(ccString1,ccString2)==0)
       cout<<ccString2;
    else
       cout<<ccString1;
}

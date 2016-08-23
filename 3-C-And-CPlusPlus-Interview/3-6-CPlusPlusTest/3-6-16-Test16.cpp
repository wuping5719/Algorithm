#include "stdafx.h"
#include <stdio.h>

void main(){
    int b=10,a=-11;
    a%=b%=4;
    printf("%d %d\n",a,b);
}

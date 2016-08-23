#include "stdafx.h"
#include <stdint.h>
#include <stdio.h>

union X
{
    int32_t a;
    struct 
    {
        int16_t b;
        int16_t c;
    };
};

int main(){
    X x;
    x.a=0x20150810;
    printf("%x,%x\n",x.b,x.c);
    return 0;
}

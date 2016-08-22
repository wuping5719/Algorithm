#include "stdafx.h"
#include <iostream>
 
void GetMemeory(char *p)
{
    p = (char *)malloc(100);
}

void main()
{
    char *str = NULL;
    GetMemeory(str);
    strcpy(str, "Thunder");
    strcat(str + 2, "Downloader");
    printf(str);
}

#include "stdafx.h"
#include<iostream>
using namespace std;
 
class Base
{
public:
    virtual int foo(int x)
    {
        return x * 10;
    }
 
    int foo(char x[14])
    {
        return sizeof(x) + 10;
    }
};
 
class Derived: public Base
{
    int foo(int x)
    {
        return x * 20;
    }
 
    virtual int foo(char x[10])
    {
        return sizeof(x) + 20;
    }
};
 
int main()
{
    Derived stDerived;
    Base *pstBase = &stDerived;
 
    char x[10];
    printf("%d\n", pstBase->foo(100) + pstBase->foo(x));
    return 0;
}

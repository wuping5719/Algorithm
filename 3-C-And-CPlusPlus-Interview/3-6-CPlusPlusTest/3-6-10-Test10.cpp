#include "stdafx.h"
#include <stdio.h>
#include <iostream>
#include <string>
using namespace std;
class Printer{
    public:
        Printer(std::string name) {
			std::cout<<name;
		}
};
class Container{
    public:
        Container() : b("b"), a("a") {}
    Printer a;
    Printer b;
};

int main(){
    Container c;
    return 0;
}

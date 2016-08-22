#include "stdafx.h"
#include <iostream>
using namespace std;
 
class A {
    public:
    ~A() {
        cout << "~A()";
    }
};
class B{
    public:
    virtual ~B() {
      cout<<"~B()";
    }
};
class C: public A, public B {
    public:
    ~C() {
        cout<<"~C()";
    }
};
int main() {
    C * c = new C;
    B * b1 = dynamic_cast<B *>(c);
    A * a2 = dynamic_cast<A *>(b1);
    delete a2;
}

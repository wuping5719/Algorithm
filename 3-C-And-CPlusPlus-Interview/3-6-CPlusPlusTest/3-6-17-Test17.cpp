#include "stdafx.h"
#include <iostream>
using namespace std;

class parent
{  
   int i;
  protected:
    int x;
  public:
   parent(){x=0;i=0;}
   void change(){x++;i++;}
   void display();
};

class son:public parent
{
    public:
        void modify();
};

 void parent::display(){cout<<"x="<<x<<endl;}
 void son:: modify() {x++;}

int main()
{ 
  son A; parent B;
  A.display();
  A.change();
  A.modify(); 
  A.display();
  B.change();
  B.display();
}

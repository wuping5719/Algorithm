// GreatestCommonDivisor.cpp : 求最大公约数
//

#include "stdafx.h"
#include "stdio.h"

//辗转相除法
int gcd1(int x, int y)
{
	return (!y) ? x: gcd1(y, x%y);
}

//更相减损法
int gcd2(int x, int y)
{
	if(x < y)
		return gcd2(y, x);
	if(y == 0)
		return x;
	else
		return gcd2(x - y, y);
}

bool IsEven(int n)
{
	return n & 0x1 == 0 ? true : false;
}

//移位法
int gcd3(int x, int y)
{
	if(x < y)
		return gcd3(y ,x);
	if(y == 0)
		return x;
	else
	{
		if(IsEven(x))
		{
			if(IsEven(y))
				return (gcd3(x >> 1, y >> 1) << 1);
			else
				return gcd3(x >> 1, y);
		}
		else
		{
			if(IsEven(y))
				return gcd3(x, y >> 1);
			else
				return gcd3(y, x - y);
		}
	}
}

int _tmain(int argc, _TCHAR* argv[])
{
	int x, y;
    printf("请输入第一个数x:");
	scanf("%d", &x);
	printf("请输入第二个数y:");
	scanf("%d", &y);
	if(x <= 0){
		printf("输入非法，请重新输入x! \n");
		printf("请输入第一个数x:");
	    scanf("%d", &x);
	}
	if(y <= 0){
		printf("输入非法，请重新输入y! \n");
		printf("请输入第二个数y:");
	    scanf("%d", &y);
	}
	printf("1.使用辗转相除法计算的最大公约数结果：%d \n", gcd1(x, y));
	printf("2.使用更相减损法计算的最大公约数结果：%d \n", gcd2(x, y));
	printf("3.使用移位法计算的最大公约数结果：%d \n", gcd3(x, y));
	return 0;
}


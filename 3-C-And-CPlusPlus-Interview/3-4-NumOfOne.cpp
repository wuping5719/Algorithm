// NumOfOne.cpp : 求无符号整数中1的个数

#include "stdafx.h"
#include "stdio.h"

long Sum1s(unsigned long n)
{
	unsigned long iCount = 0;
	unsigned long iFactor = 1;
	unsigned long iLowerNum = 0;
    unsigned long iCurrNum = 0;
	unsigned long iHigherNum = 0;
	while(n / iFactor != 0)
	{
		iLowerNum = n - (n / iFactor) * iFactor;
		iCurrNum = (n / iFactor) % 10;
		iHigherNum = n / (iFactor * 10);

		switch(iCurrNum)
		{
		case 0:
			iCount += iHigherNum * iFactor;
			break;
		case 1:
			iCount += iHigherNum * iFactor + iLowerNum + 1;
			break;
		default:
			iCount += (iHigherNum + 1) * iFactor;
			break;
		}

		iFactor *= 10;
	}

	return iCount;
}


int _tmain(int argc, _TCHAR* argv[])
{
	unsigned long n = 100;
	printf("请输入一个无符号整数: ");
	scanf("%u", &n);
	long count;
	count = Sum1s(n);
	printf("%u中1的个数: %ld. \n", n,count);
	return 0;
}


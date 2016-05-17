// GeneralsOfChineseChess.cpp : 中国象棋将帅对决

#include "stdafx.h"
#include "stdio.h"
//记忆存储单元的一半，这里是4bit
#define HALF_BITS_LENGTH 4
//全部bit的Max，二进制表示为：11111111
#define FULLMAX 255
//左bit的Max，二进制表示为：11110000
#define LMAX  (FULLMAX << HALF_BITS_LENGTH)
//右bit的Max，二进制表示为：00001111
#define RMAX  (FULLMAX >> HALF_BITS_LENGTH)
//将b的右边设置为n
#define RSET(b, n)  (b = ((LMAX & b)  ^ n))
//将b的左边设置为n
#define LSET(b, n)  (b = ((RMAX & b)  ^ (n << HALF_BITS_LENGTH)))
//得到b的右边的值
#define RGET(b)  (RMAX & b) 
//得到b的左边的值
#define LGET(b)   ((LMAX & b) >> HALF_BITS_LENGTH)
//将帅移动范围的行宽度
#define GRIDW 3

int _tmain(int argc, _TCHAR* argv[])
{
	unsigned char b;
	for(LSET(b, 1); LGET(b) <= GRIDW * GRIDW; LSET(b, (LGET(b) + 1 )))
		for(RSET(b, 1); RGET(b) <= GRIDW * GRIDW; RSET(b, (RGET(b) + 1 )))
			if(LGET(b) % GRIDW != RGET(b) % GRIDW)
				printf("A = %d, B = %d\n", LGET(b), RGET(b));
	return 0;
}


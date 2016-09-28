package acmCoder;

import java.util.Random;

/**
 * @author WuPing
 * @version 2016年9月28日 下午3:47:48
 */

public class GrabRedPackage {

     // 微信红包的随机算法是怎样实现的？
     // http://www.zhihu.com/question/22625187
    
     // JAVA实现仿微信红包分配规则 
     // http://blog.csdn.net/xiaojimanman/article/details/50708860
    
     public static class RedPackage {
	int remainSize;    // remainSize 剩余的红包数量
	double remainMoney;  // remainMoney 剩余的钱
	
	RedPackage(int remainSize, double remainMoney) {
	    this.remainSize = remainSize;
	    this.remainMoney = remainMoney;
	}
     }
    
    public static double getRandomMoney(RedPackage _redPackage) {
	if (_redPackage.remainSize == 1) {
	    _redPackage.remainSize--;
	    return (double) Math.round(_redPackage.remainMoney * 100) / 100;
	}
	Random r = new Random();
	double min = 0.01; 
	double max = _redPackage.remainMoney / _redPackage.remainSize * 2;
	double money = r.nextDouble() * max;
	money = money <= min ? 0.01 : money;
	money = Math.floor(money * 100) / 100;
	_redPackage.remainSize--;
	_redPackage.remainMoney -= money;
	return money;
    }
    
    public static void main(String[] args) {
	int remainSize  = 30;
	double remainMoney = 500;
	RedPackage redPackage = new RedPackage(remainSize, remainMoney);
	for(int i=0; i<30; i++) {
	    double money = getRandomMoney(redPackage);
	    System.out.println((i+1) + ": " + money);
	}
    }

}

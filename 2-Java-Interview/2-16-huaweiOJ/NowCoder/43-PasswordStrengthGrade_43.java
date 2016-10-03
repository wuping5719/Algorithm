package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月3日 下午7:18:56
 */

public class PasswordStrengthGrade_43 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
        while(cin.hasNext()) {
            String str = cin.nextLine();
            
            char[] array = str.toCharArray();
            int length = array.length;  //密码长度
            int upperCaseNum = 0;       //大写字母数量
            int lowerCaseNum = 0;       //小写字母数量
            int digitNum = 0;           //数字数量
            int otherNum = 0;           //其他字符
            int score = 0;              //分数
            
            for(int i=0; i<length; i++) {
        	if(array[i]>='A' && array[i]<='Z') {
        	    upperCaseNum++;
        	}else if(array[i]>='a' && array[i]<='z') {
        	    lowerCaseNum++;
        	}else if(array[i]>='0' && array[i]<='9') {
        	    digitNum++;
        	}else {
        	    otherNum++;
        	}
            }
            
            //密码长度
            if(length <= 4) {
        	score = score + 5;     //5 分: 小于等于4 个字符
            }else if(length >= 5 && length <= 7) {
        	score = score + 10;    //10 分: 5 到7 字符
            }else {
        	score = score + 25;    //25 分: 大于等于8 个字符
            }
            
            //字母
            if(upperCaseNum==0 && lowerCaseNum==0) {
        	score = score + 0;    //0 分: 没有字母
            }else if(upperCaseNum!=0 && lowerCaseNum==0 && digitNum==0 && otherNum==0){
        	score = score + 10;    //10 分: 全都是大写字母
            }else if(upperCaseNum==0 && lowerCaseNum!=0 && digitNum==0 && otherNum==0){
        	score = score + 10;     //10 分: 全都是小写字母
            }else if(upperCaseNum!=0 && lowerCaseNum!=0) {
        	score = score + 20;      //20 分: 大小写混合字母
            }
            
            //数字
            if(digitNum==0) {
        	score = score + 0;     //0 分: 没有数字
            }else if(digitNum==1) {
        	score = score + 10;    //10 分: 1个数字
            }else if(digitNum>1) {
        	score = score + 20;    //20 分: 大于1个数字
            }
            
            //符号
            if(otherNum==0) {
        	score = score + 0;     //0 分: 没有符号
            }else if(otherNum==1) {
        	score = score + 10;    //10 分: 1个符号
            }else if(otherNum>1) {
        	score = score + 25;    //25 分: 大于1个符号
            }
            
            //奖励
            if(upperCaseNum!=0 && lowerCaseNum==0 && digitNum!=0 && otherNum==0) {
        	score = score + 2;     //2 分: 字母和数字
            }else if(upperCaseNum==0 && lowerCaseNum!=0 && digitNum!=0 && otherNum==0) {
        	score = score + 2;     //2 分: 字母和数字
            }else if(upperCaseNum!=0 && lowerCaseNum==0 && digitNum!=0 && otherNum!=0) {
        	score = score + 3;     //3 分: 字母、数字和符号
            }else if(upperCaseNum==0 && lowerCaseNum!=0 && digitNum!=0 && otherNum!=0) {
        	score = score + 3;     //3 分: 字母、数字和符号
            }else if(upperCaseNum!=0 && lowerCaseNum!=0 && digitNum!=0 && otherNum!=0) {
        	score = score + 5;     //5 分: 大小写字母、数字和符号
            }
            
            //最后的评分标准
            if(score>=90) {                       // >= 90: 非常安全
        	System.out.println("VERY_SECURE");
            }else if(score>=80 && score<90) {     // >= 80: 安全（Secure）
        	System.out.println("SECURE");
            }else if(score>=70 && score<80) {     // >= 70: 非常强
        	System.out.println("VERY_STRONG");
            }else if(score>=60 && score<70) {     // >= 60: 强（Strong）
        	System.out.println("STRONG");
            }else if(score>=50 && score<60) {     // >= 50: 一般（Average）
        	System.out.println("AVERAGE");
            }else if(score>=25 && score<50) {     // >= 25: 弱（Weak）
        	System.out.println("WEAK");
            }else {                               // >= 0: 非常弱
        	System.out.println("VERY_WEAK");
            }
        }
        cin.close();
    }

}

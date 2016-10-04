package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月4日 下午4:54:04
 */

public class DateToDayNum_57 {

    private static int calculateDayNum(int year, int month, int day) {
        int [] dayOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if(year <= 0 || month <= 0 || month > 12 || day<= 0 || day > dayOfMonth[month - 1]) {
            return -1; 
        } 
        //判断是否为闰年
        if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
            dayOfMonth[1] = 29;
        }
         
        int sum = 0;
        for(int i=0; i<month-1; i++){
            sum += dayOfMonth[i] ;
        }
        sum = sum + day;
        return sum;
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    int year = cin.nextInt();
	    int month = cin.nextInt();
	    int day = cin.nextInt();
	    
	    int dayNum = calculateDayNum(year, month, day);
	    System.out.println(dayNum);
	}
	cin.close();
    }

}

package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月6日 下午9:00:18
 */

public class LearnEnglish_98 {

    private static String[] oneBit = {"zero", "one", "two", "three", "four",
	"five", "six", "seven", "eight", "nine"};
    
    private static String[] tenBit = {"ten", "eleven", "twelve", "thirteen", 
	"fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nighteen"};
    
    private static String[] wholeTen = {"twenty", "thirty", "forty", "fifty",
        "sixty", "seventy", "eighty", "ninety"};
    
    public static String parse(long num){
        if(num < 0) {
            return "error";
        }
        StringBuffer sb = new StringBuffer();
        
        //十亿部分 
        long billion = num / 1000000000;  
        if(billion != 0){
            sb.append(thranslate(billion) + " billion "); //翻译十亿部分
        }
        num = num % 1000000000;   
        
        //百万部分    
        long million = num / 1000000;  
        if(million != 0){
            sb.append(thranslate(million) + " million "); //翻译百万部分
        }
        num = num % 1000000;
         
        //千部分
        long thousand = num / 1000;  
        if(thousand != 0){
            sb.append(thranslate(thousand) + " thousand ");//翻译千部分
        }    
        num = num % 1000;
        
        //百部分
        if(num != 0){ 
            sb.append(thranslate(num));  //翻译百部分
        }
        return sb.toString().trim();  //去除字符串后面的空格
    }
     
    //翻译方法
    public static String thranslate(long num){
        StringBuffer sb = new StringBuffer();

        //百位处理
        long h = num / 100;
        if(h != 0){ //若不为0, 翻译, 否则不翻译  
            sb.append(oneBit[(int) h] + " hundred");
        }
        num = num % 100;
        
        //十位部分
        long k = num / 10;
        if(k != 0){
            if(h != 0) {  //如果有百位别忘了加and
        	 sb.append(" and ");
            }
            if(k == 1){   //若十位为1, 连同个位一起翻译
                long t = num % 10;
                sb.append(tenBit[(int) t]);
            }else{   //否则, 十位和个位分别单独翻译
                sb.append(wholeTen[(int)k - 2] + " ");
                if(num % 10 != 0) {
                    sb.append(oneBit[(int)(num % 10)]);
                }
            }
        }else if(num % 10 != 0){ //如果没有十位部分, 直接翻译个位部分
            if(h != 0) {
        	sb.append(" and ");
            }  
            sb.append(oneBit[(int)(num % 10)]);
        }
        return sb.toString().trim(); 
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
        while(cin.hasNext()){
            long n = cin.nextLong();
            System.out.println(parse(n));
        }
        cin.close();
    }

}

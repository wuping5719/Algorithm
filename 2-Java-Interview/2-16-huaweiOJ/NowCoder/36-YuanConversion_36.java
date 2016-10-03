package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月2日 下午11:10:37
 */

public class YuanConversion_36 {

    private static String[] map = {"壹","贰","叁","肆","伍","陆","柒","捌","玖"};
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    String num =  cin.next();
	    resolve(num);
	}
        cin.close();
    }
    
    public static void resolve(String str){
        String[] strArr = str.split("\\.");
        long number = Integer.valueOf(str.split("\\.")[0]);
        
        StringBuffer res = new StringBuffer("人民币");
        long yi = (long)(number/100000000);
        if(yi != 0){
            res.append(resolveQian(yi)).append("亿");
            number = number - yi*100000000;
        }
         
        long wan = (long)(number/10000);
        if(wan!=0){
            res.append(resolveQian(wan)).append("万");
            number = number - wan*10000;
        }
         
         //处理千百十个位
        String beforePointStr = resolveQian(number);
        if(beforePointStr.length() > 1){
             res.append(beforePointStr).append("元");
        }
         
        //若有小数点, 处理小数点后面位数
        if(strArr.length > 1){
             String afterPointStr = strArr[1];
             res.append(handleNumberAfterPoint(afterPointStr));
        }
         
        //在resolveQian()方法里可能会返回: 零xxx, 但在最高为不能有"零"
        String resString = res.toString();
       
        if(resString.length()>4 && resString.charAt(3)=='零' && resString.charAt(4)!='元'){
            resString = resString.substring(0,3) + resString.substring(4);
        }
 
        System.out.println(resString);
    }
     
    //处理4位数 千百十个位
    public static String resolveQian(double temp){
        StringBuffer resBuffer = new StringBuffer();
         
        //千位
        int qian = (int)(temp/1000);
        if(qian != 0){
            resBuffer.append(map[qian-1]).append("仟");
            temp = temp - qian*1000;
        }
         
        //百位
        int bai = (int)(temp/100);
        if(bai != 0){
            resBuffer.append(map[bai-1]).append("佰");
            temp = temp - bai*100;
        }
        //注意: 零 只会添加在百位和十位
        if(qian != 0 && bai == 0){
            resBuffer.append("零");
        }
         
        //十位
        int shi = (int)(temp/10);
        if(shi != 0){
            if(shi != 1){
                resBuffer.append(map[shi-1]);
            }
            resBuffer.append("拾");
            temp = temp - shi*10;
        }
         
        //注意：0
        if(bai != 0&& shi == 0){
            resBuffer.append("零");
        }
         
        //个位
        int ge = (int)(temp%10);
         
        if(ge != 0){
            //5,0001 这种情况, 千百十位均为0
            if(qian==0 && bai==0 && shi==0){
                resBuffer.append("零");
            }
            resBuffer.append(map[ge-1]);
        }

        return resBuffer.toString();
    }
     
    //处理小数点后面的数
    public static String handleNumberAfterPoint(String str){
	StringBuffer resBuffer = new StringBuffer();
        if(str.equals("00") || str.equals("0")){
            resBuffer.append("整");
        }else{
            if(str.charAt(0) != '0'){
        	resBuffer.append(map[Integer.valueOf(str.charAt(0)+"")-1]);
        	resBuffer.append("角");
            }
            if(str.length()>1 && str.charAt(1)!='0'){
        	resBuffer.append(map[Integer.valueOf(str.charAt(1)+"")-1]);
        	resBuffer.append("分");
            }
        }
        return resBuffer.toString();
    }

}

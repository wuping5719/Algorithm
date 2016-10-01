package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月1日 上午11:12:52
 */

public class MovePoint_17 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    String str = cin.nextLine();
	    if(!str.trim().equals("")) {
		String[] strArray = str.split(";");
		int pointX = 0;    // X坐标
		int pointY = 0;    // Y坐标
		for(int i=0; i<strArray.length; i++) {
		    if(strArray[i].length() == 3 || strArray[i].length() == 2) {   // 操作码长度合法, 非法不予处理, 直接略过
			char[] tempArray = strArray[i].toCharArray();
			if(tempArray[0]=='A') {       // 向左移动
			    // 数字(两位以内)
			    if(strArray[i].length() == 2) {
				if('0'<=tempArray[1] && tempArray[1]<='9') {
				    String stepSizeStr = "" + tempArray[1];
				    int stepSize = Integer.parseInt(stepSizeStr);
				    pointX = pointX - stepSize;
				}
			    }else {
				if('0'<=tempArray[1] && tempArray[1]<='9' && '0'<=tempArray[2] && tempArray[2]<='9') {
				    String stepSizeStr = "" + tempArray[1] + tempArray[2];
				    int stepSize = Integer.parseInt(stepSizeStr);
				    pointX = pointX - stepSize;
				}
			    }
			}else if(tempArray[0]=='D'){  // 向右移动
			    if(strArray[i].length() == 2) {
				if('0'<=tempArray[1] && tempArray[1]<='9') {
				    String stepSizeStr = "" + tempArray[1];
				    int stepSize = Integer.parseInt(stepSizeStr);
				    pointX = pointX + stepSize;
				}
			    }else {
				if('0'<=tempArray[1] && tempArray[1]<='9' && '0'<=tempArray[2] && tempArray[2]<='9') {
				    String stepSizeStr = "" + tempArray[1] + tempArray[2];
				    int stepSize = Integer.parseInt(stepSizeStr);
				    pointX = pointX + stepSize;
				}
			    }
			}else if(tempArray[0]=='W'){  // 向上移动
			    if(strArray[i].length() == 2) {
				if('0'<=tempArray[1] && tempArray[1]<='9') {
				    String stepSizeStr = "" + tempArray[1];
				    int stepSize = Integer.parseInt(stepSizeStr);
				    pointY = pointY + stepSize;
				}
			    }else {
				if('0'<=tempArray[1] && tempArray[1]<='9' && '0'<=tempArray[2] && tempArray[2]<='9') {
				    String stepSizeStr = "" + tempArray[1] + tempArray[2];
				    int stepSize = Integer.parseInt(stepSizeStr);
				    pointY = pointY + stepSize;
				}
			    }
			}else if(tempArray[0]=='S'){  // 向下移动
			    if(strArray[i].length() == 2) {
				if('0'<=tempArray[1] && tempArray[1]<='9') {
				    String stepSizeStr = "" + tempArray[1];
				    int stepSize = Integer.parseInt(stepSizeStr);
				    pointY = pointY - stepSize;
				}
			    }else {
				if('0'<=tempArray[1] && tempArray[1]<='9' && '0'<=tempArray[2] && tempArray[2]<='9') {
				    String stepSizeStr = "" + tempArray[1] + tempArray[2];
				    int stepSize = Integer.parseInt(stepSizeStr);
				    pointY = pointY - stepSize;
				}
			    }
			}
		    }
		}
		System.out.println(pointX + "," + pointY);
	    }
	}
	cin.close();
    }

}

package leetcode;

import java.util.HashMap;

/**
 * @author WuPing
 * @version 2016年10月21日 下午7:39:34
 */

class Point {
   int x;
   int y;
   Point() { 
       x = 0; 
       y = 0; 
   }
   Point(int a, int b) {
       x = a; 
       y = b; 
   }
}

public class MaxPointsOnaALine_3 {

    //穷举: 考虑特殊情况: 斜率不存在、点重合、HashMap里-0.0和0.0是不同的key.
    public static int maxPoints(Point[] points) {
	Double k;
        int x, y, max = 0;
        for(int i = 0; i < points.length; i++) {
            HashMap<Double, Integer> map = new HashMap<Double, Integer>();
            int curMax = 1, repNum = 0;
            x = points[i].x; 
            y = points[i].y;
            for(int j = i + 1; j < points.length; j++) {
                int num = 1;
                if(x == points[j].x && y == points[j].y) {
                    repNum += 1;
                }else {
                    if(x != points[j].x) {
                	if(y == points[j].y) {   
                	    k = 0.0;
                	}else { 
                	    k = 1.0 * (y - points[j].y) / (x - points[j].x);
                	} 
                    }else {
                	k = Double.MAX_VALUE;
                    }
                        
                    if(map.get(k) != null) {
                	num = map.get(k) + 1;
                    }else {
                	num = 2;
                    }   
                    map.put(k, num);
                }
                 
                if(curMax < num) { 
                    curMax = num;
                } 
            }
             
            curMax += repNum;
            if(max < curMax) {
        	max = curMax;
            }
        }
        return max;
    }
    
    public static void main(String[] args) {
	Point point1 = new Point(0, 1);
	Point point2 = new Point(2, 3);
	Point point3 = new Point(-6, 8);
	Point point4 = new Point(3, 9);
	Point point5 = new Point(5, 1);
	Point[] points = {point1, point2, point3, point4, point5};
	System.out.println(maxPoints(points));
    }
}
